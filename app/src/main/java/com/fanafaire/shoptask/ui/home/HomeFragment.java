package com.fanafaire.shoptask.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fanafaire.shoptask.MainActivity;
import com.fanafaire.shoptask.R;
import com.fanafaire.shoptask.adapter.NodeAdapter;
import com.fanafaire.shoptask.databinding.FragmentHomeBinding;
import com.fanafaire.shoptask.nodes.ProductNode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<ProductNode> products = new ArrayList<ProductNode>();

    private FragmentHomeBinding binding;
    public RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
//        return v;

//        super.onCreate(savedInstanceState); // ??

//        recyclerView.findViewById(R.id.recyclerView);

//        final  = binding.recyclerView;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // начальная инициализация списка
//        setInitialData(products);
//        recyclerView = findViewById(R.id.recyclerView);
        // создаем адаптер
        NodeAdapter adapter = new NodeAdapter(getContext(), setInitialData(products));
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        return root;
    }

    private ArrayList<ProductNode> setInitialData(ArrayList<ProductNode> productNode){
        ArrayList<ProductNode> productList = new ArrayList<>();
        productList.add(new ProductNode (1, "Product 1", 10));
        productList.add(new ProductNode (2, "Product 2", 15));
        productList.add(new ProductNode (3, "Product 3", 40));
        productList.add(new ProductNode (4, "Product 4", 5));
        productList.add(new ProductNode (5, "Product 5", 100));

        return productList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}