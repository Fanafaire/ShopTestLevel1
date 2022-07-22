package com.fanafaire.shoptask.ui.prodUser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fanafaire.shoptask.databinding.FragmentProdUserBinding;

public class ProdUserFragment extends Fragment {

    private FragmentProdUserBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProdUserViewModel prodUserViewModel =
                new ViewModelProvider(this).get(ProdUserViewModel.class);

        binding = FragmentProdUserBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textProdUser;
        prodUserViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}