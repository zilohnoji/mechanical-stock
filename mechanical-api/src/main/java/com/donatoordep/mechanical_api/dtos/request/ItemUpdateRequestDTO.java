package com.donatoordep.mechanical_api.dtos.request;

public final class ItemUpdateRequestDTO {

    private Long id;
    private String name;
    private int quantity;
    private double price;

    private ItemUpdateRequestDTO() {
    }

    public Long getId() {
        return id;
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