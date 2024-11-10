package com.donatoordep.mechanical_api.dtos.response;

public final class ItemGetAllResponseDTO {

    private Long itemId;
    private ProductGetAllResponseDTO product;
    private int quantity;
    private double totalPrice;

    private ItemGetAllResponseDTO(ProductGetAllResponseDTO product, int quantity, double totalPrice, Long itemId) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.itemId = itemId;
    }

    public static ItemGetAllResponseDTO of(ProductGetAllResponseDTO product, int quantity, double totalPrice, Long itemId) {
        return new ItemGetAllResponseDTO(product, quantity, totalPrice, itemId);
    }

    public ProductGetAllResponseDTO getProduct() {
        return product;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
