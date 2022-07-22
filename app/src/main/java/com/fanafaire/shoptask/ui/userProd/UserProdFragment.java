package com.fanafaire.shoptask.ui.userProd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fanafaire.shoptask.databinding.FragmentUserProdBinding;

public class UserProdFragment extends Fragment {

    private FragmentUserProdBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserProdViewModel userProdViewModel =
                new ViewModelProvider(this).get(UserProdViewModel.class);

        binding = FragmentUserProdBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textUserProd;
//        userProdViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}