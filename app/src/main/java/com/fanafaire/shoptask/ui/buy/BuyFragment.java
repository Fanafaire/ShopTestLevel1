package com.fanafaire.shoptask.ui.buy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fanafaire.shoptask.MainActivity;
import com.fanafaire.shoptask.R;
import com.fanafaire.shoptask.nodes.ProductNode;
import com.fanafaire.shoptask.nodes.UserNode;

import java.util.ArrayList;

public class BuyFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BuyViewModel buyViewModel =
                new ViewModelProvider(this).get(BuyViewModel.class);

        View root = inflater.inflate(R.layout.fragment_buy, container, false);

        Button buyButton = (Button)root.findViewById(R.id.buy_button);

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int productID = getProductId(root);
                int userID = getUserId(root);

                ArrayList<ProductNode> currentProducts = ((MainActivity) getActivity()).getProducts();
                ArrayList<UserNode> currentUsers = ((MainActivity) getActivity()).getUsers();

                if(checkIDs(productID, userID, currentProducts.size(), currentUsers.size())){
                    ProductNode currentProduct = getCurrentProduct(currentProducts, productID);
                    UserNode currentUser = getCurrentUser(currentUsers, userID);

                    buyProduct(currentProduct, currentUser);

                }
            }
        });

        return root;
    }

    private void buyProduct(ProductNode currentProduct, UserNode currentUser) {
        if(currentProduct.getPrice() <= currentUser.getAmount()){
            // add userId to product
            ((MainActivity) getActivity()).addProdUser(currentProduct.getId(), currentUser.getId());
            // add productId to user
            ((MainActivity) getActivity()).addUserProd(currentProduct.getId(), currentUser.getId());
            // change user amount
            ((MainActivity) getActivity()).changeAmount(currentUser.getId(), currentProduct.getPrice());

            Toast.makeText(getContext(), "Buy successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Can`t buy: user have no enough money", Toast.LENGTH_SHORT).show();
        }


    }

    private ProductNode getCurrentProduct(ArrayList<ProductNode> currentProducts, int productID) {
        ProductNode currentProduct = new ProductNode(-1,"No Product", 0);

        for(ProductNode item : currentProducts){

            if(item.getId() == productID) {
                currentProduct = item;
                break;
            }
        }

        System.out.println(currentProduct.getName());

        return currentProduct;
    }

    private UserNode getCurrentUser(ArrayList<UserNode> currentUsers, int userID) {
        UserNode currentUser = new UserNode(-1,"No Product", "", 0);;

        for(UserNode item : currentUsers){
            if(item.getId() == userID) {
                currentUser = item;
                break;
            }
        }

        return currentUser;
    }

    private boolean checkIDs(int productID, int userID, int productsSize, int usersSize) {

        if(productID <= 0 || productsSize < productID){
            Toast.makeText(getContext(), "Please, enter correct Product ID", Toast.LENGTH_SHORT).show();

            return false;
        }

        if (userID <= 0 || usersSize < userID) {
            Toast.makeText(getContext(), "Please, enter correct User ID", Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }

    private int getProductId(View root) {

        EditText editText = root.findViewById(R.id.product_id);
        String text = editText.getText().toString();

        return text.length() != 0 ? Integer.parseInt (text) : 0;
    }

    private int getUserId(View root) {

        EditText editText = root.findViewById(R.id.user_id);
        String text = editText.getText().toString();

        return text.length() != 0 ? Integer.parseInt (text) : 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}