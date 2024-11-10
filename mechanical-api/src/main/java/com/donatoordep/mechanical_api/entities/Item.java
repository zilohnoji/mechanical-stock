package com.donatoordep.mechanical_api.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_item")
public final class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private double totalPrice;

    private Item() {
    }

    private Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = quantity * product.getPrice();
    }

    private Item(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = quantity * product.getPrice();
    }

    public static Item of(String productName, double productPrice, int quantity) {
        return new Item(Product.of(productName, productPrice), quantity);
    }

    public static Item of(Long id, String productName, double productPrice, int quantity) {
        return new Item(id, Product.of(productName, productPrice), quantity);
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}