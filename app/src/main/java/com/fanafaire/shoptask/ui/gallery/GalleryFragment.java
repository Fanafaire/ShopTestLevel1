package com.fanafaire.shoptask.ui.gallery;

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
import com.fanafaire.shoptask.adapter.UserNodeAdapter;
import com.fanafaire.shoptask.nodes.UserNode;

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

        UserNodeAdapter adapter = new UserNodeAdapter(getContext(), setInitialData());
        recyclerView.setAdapter(adapter);

        return root;
    }

    private ArrayList<UserNode> setInitialData(){
        return ((MainActivity)getActivity()).getUsers();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}