package com.fanafaire.shoptask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fanafaire.shoptask.R;
import com.fanafaire.shoptask.nodes.ProductNode;

import java.util.ArrayList;
import java.util.List;

public class NodeAdapter extends RecyclerView.Adapter<NodeAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final ArrayList<ProductNode> products;

    public NodeAdapter(Context context, ArrayList<ProductNode> products) {
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NodeAdapter.ViewHolder holder, int position) {
        ProductNode product = products.get(position);
        holder.idView.setText(Integer.toString(product.getId()));
        holder.nameView.setText(product.getName());
        holder.priceView.setText(Integer.toString(product.getPrice()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView idView, nameView, priceView;
        ViewHolder(View view){
            super(view);
            idView = view.findViewById(R.id.id);
            nameView = view.findViewById(R.id.name);
            priceView = view.findViewById(R.id.price);
        }
    }
}