package com.fanafaire.shoptask.ui.buy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fanafaire.shoptask.databinding.FragmentBuyBinding;

public class BuyFragment extends Fragment {

    private FragmentBuyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BuyViewModel buyViewModel =
                new ViewModelProvider(this).get(BuyViewModel.class);

        binding = FragmentBuyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBuy;
        buyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}