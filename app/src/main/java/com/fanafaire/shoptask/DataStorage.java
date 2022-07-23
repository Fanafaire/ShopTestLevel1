package com.fanafaire.shoptask;

import android.content.Context;

import com.fanafaire.shoptask.nodes.ProductNode;
import com.fanafaire.shoptask.nodes.UserNode;

import java.util.ArrayList;

public class DataStorage {

    private ArrayList<ProductNode> products;
    private ArrayList<UserNode> users;
    private Context context;

    public DataStorage(){
        products = setProductsData();
        users = setUsersData();

        products.get(1).addUser(2);
        products.get(2).addUser(2);
        products.get(1).addUser(1);

        users.get(1).addProduct(1);
        users.get(1).addProduct(1);
        users.get(1).addProduct(2);

        users.get(2).addProduct(3);
        users.get(2).addProduct(3);
    }

    public ArrayList<ProductNode> getProducts() {
        return products;
    }

//    public void setProducts(ArrayList<ProductNode> products) {
//        this.products = products;
//    }

    public ArrayList<UserNode> getUsers() {
        return users;
    }

//    public void setUsers(ArrayList<UserNode> users) {
//        this.users = users;
//    }

    private ArrayList<ProductNode> setProductsData(){
        ArrayList<ProductNode> productList = new ArrayList<>();
        productList.add(new ProductNode (1, "Product 1", 10));
        productList.add(new ProductNode (2, "Product 2", 15));
        productList.add(new ProductNode (3, "Product 3", 40));
        productList.add(new ProductNode (4, "Product 4", 5));
        productList.add(new ProductNode (5, "Product 5", 100));

        return productList;
    }

    private ArrayList<UserNode> setUsersData(){
        ArrayList<UserNode> productList = new ArrayList<>();
        productList.add(new UserNode (1, "First Name 1","Second Name 1", 1000));
        productList.add(new UserNode (2, "First Name 2","Second Name 2", 10));
        productList.add(new UserNode (3, "First Name 3","Second Name 3", 50));
        productList.add(new UserNode (4, "First Name 4","Second Name 4", 500));
        productList.add(new UserNode (5, "First Name 5","Second Name 5", 100));

        return productList;
    }


}
