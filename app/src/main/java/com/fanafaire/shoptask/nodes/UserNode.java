package com.fanafaire.shoptask.nodes;

import java.io.Serializable;
import java.util.HashMap;

public class UserNode implements Serializable {

    private int id = 0;
    private String firstName = "test";
    private String secondName = "test";
    private int amount = 0;
    private HashMap<Integer, Integer> products;

    public UserNode(int id, String firstName, String secondName, int price){

        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.amount = price;
        this.products = new HashMap<>();
    }

    public boolean addProduct(int productID) {
        if (productID < 1) {
            return false;
        }

        if(products.size() == 0 || !products.containsKey(productID)){
            products.put(productID, 1);

            return true;
        }

        if (products.containsKey(productID)){
            products.put(productID, products.get(productID) + 1);

            return true;
        }

        return false;
    }

    public int[][] getProducts() {

        if(products.size() != 0) {
            int[][] result = new int[products.size()][2];

            int i = 0;
            for (int key: products.keySet()) {
                result[i][0] = key;
                result[i][1] = products.get(key);

                i ++;
            }

            return result;
        }

        return null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
