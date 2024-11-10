package com.donatoordep.mechanical_api.dtos.response;

public final class ProductGetAllResponseDTO {
    private String name;
    private double price;

    private ProductGetAllResponseDTO(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static ProductGetAllResponseDTO of(String name, double price) {
        return new ProductGetAllResponseDTO(name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}