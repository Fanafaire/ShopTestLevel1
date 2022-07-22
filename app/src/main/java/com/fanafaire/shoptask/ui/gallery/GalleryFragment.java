package com.fanafaire.shoptask.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fanafaire.shoptask.R;
import com.fanafaire.shoptask.adapter.NodeAdapter;
//import com.fanafaire.shoptask.databinding.FragmentGalleryBinding;
import com.fanafaire.shoptask.nodes.ProductNode;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

//    private FragmentGalleryBinding binding;

    public RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        NodeAdapter adapter = new NodeAdapter(getContext(), setInitialData());
        recyclerView.setAdapter(adapter);

        return root;
    }

    private ArrayList<ProductNode> setInitialData(){
        ArrayList<ProductNode> productList = new ArrayList<>();
        productList.add(new ProductNode (1, "First Name 1" + "Second Name 1", 1000));
        productList.add(new ProductNode (2, "First Name 2" + "Second Name 2", 10));
        productList.add(new ProductNode (3, "First Name 3" + "Second Name 3", 50));
        productList.add(new ProductNode (4, "First Name 4" + "Second Name 4", 500));
        productList.add(new ProductNode (5, "First Name 5" + "Second Name 5", 100));

        return productList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}