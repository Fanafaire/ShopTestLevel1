package com.fanafaire.shoptask.nodes;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductNode implements Serializable {

    private int id = 0;
    private String name = "test";
    private int price = 0;
    private ArrayList<Integer> users;

    public ProductNode(int id, String name, int price){

        this.id = id;
        this.name = name;
        this.price = price;
        this.users = new ArrayList<>();
    }

    public int[] getUsers() {
        if (users.size() != 0){
            int[] result = new int[users.size()];

            for (int i = 0; i < users.size(); i++) {
                result[i] = users.get(i);
            }

            return result;
        }

        return null;
    }

    public boolean addUser(int userID) {
        if (userID < 1) {
            return false;
        }

        if (users.size() == 0 || !users.contains(userID)) {
            users.add(userID);

            return true;
        }

        return false;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
