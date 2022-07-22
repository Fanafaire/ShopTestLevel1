package com.fanafaire.shoptask.nodes;

public class ProductNode {

    private int id = 0;
    private String name = "test";
    private int price = 0;

    public ProductNode(int id, String name, int price){

        this.id = id;
        this.name = name;
        this.price = price;
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
