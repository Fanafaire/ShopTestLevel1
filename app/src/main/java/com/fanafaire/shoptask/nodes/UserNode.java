package com.fanafaire.shoptask.nodes;

import java.io.Serializable;
import java.util.ArrayList;

public class UserNode implements Serializable {

    private int id = 0;
    private String firstName = "test";
    private String secondName = "test";
    private int amount = 0;
    private ArrayList<Integer> products;

    public UserNode(int id, String firstName, String secondName, int price){

        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.amount = price;
        this.products = new ArrayList<>();
    }

    public boolean addProduct(int productID) {
        if (productID < 1) {
            return false;
        }

        products.add(productID);

        return true;
    }

    public int[] getProducts() {

        if (products.size() != 0){
            int[] result = new int[products.size()];

            for (int i = 0; i < products.size(); i++) {
                result[i] = products.get(i);
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
