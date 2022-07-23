package com.fanafaire.shoptask.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fanafaire.shoptask.MainActivity;
import com.fanafaire.shoptask.R;
import com.fanafaire.shoptask.adapter.ProductsNodeAdapter;
//import com.fanafaire.shoptask.databinding.FragmentHomeBinding;
import com.fanafaire.shoptask.nodes.ProductNode;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

//    private FragmentHomeBinding binding;
    public RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ProductsNodeAdapter adapter = new ProductsNodeAdapter(getContext(), setInitialData());
        recyclerView.setAdapter(adapter);


//        ((MainActivity)getActivity()).addProdUser(2, 3);
//        System.out.println(Arrays.toString(((MainActivity) getActivity()).getProducts().get(2).getUsers()));

        return root;
    }

    private ArrayList<ProductNode> setInitialData(){
        return ((MainActivity)getActivity()).getProducts();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}