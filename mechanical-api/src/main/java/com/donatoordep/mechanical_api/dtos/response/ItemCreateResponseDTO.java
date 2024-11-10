package com.donatoordep.mechanical_api.dtos.response;

public final class ItemCreateResponseDTO {

    private Long itemId;
    private String name;
    private int quantity;
    private double price;

    private ItemCreateResponseDTO(Long itemId, String name, int quantity, double price) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public static ItemCreateResponseDTO of(Long itemId, String name, int quantity, double price) {
        return new ItemCreateResponseDTO(itemId, name, quantity, price);
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