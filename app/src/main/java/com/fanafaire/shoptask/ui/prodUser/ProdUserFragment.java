package com.fanafaire.shoptask.ui.prodUser;

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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fanafaire.shoptask.MainActivity;
import com.fanafaire.shoptask.R;
import com.fanafaire.shoptask.adapter.UserNodeAdapter;
import com.fanafaire.shoptask.nodes.ProductNode;
import com.fanafaire.shoptask.nodes.UserNode;

import java.util.ArrayList;

public class ProdUserFragment extends Fragment {

    public RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProdUserViewModel prodUserViewModel =
                new ViewModelProvider(this).get(ProdUserViewModel.class);

        View root = inflater.inflate(R.layout.fragment_prod_user, container, false);

        Button findButton = (Button)root.findViewById(R.id.find_button);

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<ProductNode> currentProducts = ((MainActivity) getActivity()).getProducts();
                int productID = getProductId(root);

                if(checkSize(currentProducts.size(), productID)) {
                    ProductNode currProduct = currentProducts.get(productID);

                    //Add product info line
                    addProductInfo(root, currProduct);

                    // Add Users info recyclerView
                    ArrayList<UserNode> users = new ArrayList<>();

                    users = getUsersByIDs(currProduct.getUsers());

                    recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
                    recyclerView.setHasFixedSize(true);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);

                    UserNodeAdapter adapter = new UserNodeAdapter(getContext(), users);
                    recyclerView.setAdapter(adapter);

                    Toast.makeText(getContext(), "Test", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    private ArrayList<UserNode> getUsersByIDs(int[] users) {
        ArrayList<UserNode> currentUsers = new ArrayList<>();

        if(users == null){
            currentUsers.add(new UserNode(0, "No Users", "", 0));
        } else {
            ArrayList<UserNode> allUsers = ((MainActivity) getActivity()).getUsers();;

            for(int i = 0; i < users.length; i++){
                currentUsers.add(allUsers.get(users[i]));
            }
        }

        return currentUsers;
    }

    private void addProductInfo(View root, ProductNode productNode) {
        TextView findTextBox1 = (TextView) root.findViewById(R.id.user_id);
        findTextBox1.setText(Integer.toString(productNode.getId()));

        TextView findTextBox2 = (TextView) root.findViewById(R.id.user_name);
        findTextBox2.setText(productNode.getName());

        TextView findTextBox3 = (TextView) root.findViewById(R.id.user_amount);
        findTextBox3.setText(Integer.toString(productNode.getPrice()));
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

    private int getProductId(View root) {

        EditText editText = root.findViewById(R.id.editTextNumber);
        String text = editText.getText().toString();

        return text.length() != 0 ? Integer.parseInt (text) - 1 : -1;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}