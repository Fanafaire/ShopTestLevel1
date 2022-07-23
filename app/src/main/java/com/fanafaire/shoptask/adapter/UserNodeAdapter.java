package com.fanafaire.shoptask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fanafaire.shoptask.R;
import com.fanafaire.shoptask.nodes.UserNode;

import java.util.ArrayList;

public class UserNodeAdapter extends RecyclerView.Adapter<UserNodeAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final ArrayList<UserNode> users;

    public UserNodeAdapter(Context context, ArrayList<UserNode> users) {
        this.users = users;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserNodeAdapter.ViewHolder holder, int position) {
        UserNode user = users.get(position);
        holder.idView.setText(Integer.toString(user.getId()));
        holder.nameView.setText(user.getFullName());
        holder.priceView.setText(Integer.toString(user.getAmount()));
    }

    @Override
    public int getItemCount() {
        return users.size();
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