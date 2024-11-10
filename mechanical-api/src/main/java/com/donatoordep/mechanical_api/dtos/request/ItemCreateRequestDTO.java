package com.donatoordep.mechanical_api.dtos.request;

public final class ItemCreateRequestDTO {

    private String name;
    private int quantity;
    private double price;

    private ItemCreateRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}