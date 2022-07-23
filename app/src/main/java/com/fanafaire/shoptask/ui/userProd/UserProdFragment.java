package com.fanafaire.shoptask.ui.userProd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fanafaire.shoptask.MainActivity;
import com.fanafaire.shoptask.R;
import com.fanafaire.shoptask.adapter.ProductsNodeAdapter;
import com.fanafaire.shoptask.nodes.ProductNode;
import com.fanafaire.shoptask.nodes.UserNode;

import java.util.ArrayList;

public class UserProdFragment extends Fragment {

    public RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_user_prod, container, false);

        Button findButton = (Button)root.findViewById(R.id.find_button);

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<UserNode> currentUsers = ((MainActivity) getActivity()).getUsers();
                int userID = getUserId(root);

                if(checkSize(currentUsers.size(), userID)) {
                    UserNode currUser = currentUsers.get(userID);

                    //Add user info line
                    addUserInfo(root, currUser);

                    // Add Products info recyclerView
                    ArrayList<ProductNode> products = new ArrayList<>();

                    products = getProductsByIDs(currUser.getProducts());

                    recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
                    recyclerView.setHasFixedSize(true);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);

                    ProductsNodeAdapter adapter = new ProductsNodeAdapter(getContext(), products);
                    recyclerView.setAdapter(adapter);

                    Toast.makeText(getContext(), "Test", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    private ArrayList<ProductNode> getProductsByIDs(int[] products) {
        ArrayList<ProductNode> currentProducts = new ArrayList<>();

        if(products == null){
            currentProducts.add(new ProductNode(0, "No Products", 0));
        } else {
            ArrayList<ProductNode> allProducts = ((MainActivity) getActivity()).getProducts();;

            for(int i = 0; i < products.length; i++){
                currentProducts.add(allProducts.get(products[i]));
            }
        }

        return currentProducts;
    }

    private void addUserInfo(View root, UserNode userNode) {
        TextView findTextBox1 = (TextView) root.findViewById(R.id.user_id);
        findTextBox1.setText(Integer.toString(userNode.getId()));

        TextView findTextBox2 = (TextView) root.findViewById(R.id.user_name);
        findTextBox2.setText(userNode.getFullName());

        TextView findTextBox3 = (TextView) root.findViewById(R.id.user_amount);
        findTextBox3.setText(Integer.toString(userNode.getAmount()));
    }

    private boolean checkSize(int size, int productID) {

        if(size != 0){
            if(productID < size && productID >= 0) // check <=!
                return true;

            Toast.makeText(getContext(), "Please, enter correct ID", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "There no any products", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    private int getUserId(View root) {

        EditText editText = root.findViewById(R.id.editTextNumber);
        String text = editText.getText().toString();

        return text.length() != 0 ? Integer.parseInt (text) - 1 : -1;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}