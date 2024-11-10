package com.donatoordep.mechanical_api.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_product")
public final class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    private Product() {
    }

    private Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    static Product of(String name, double price) {
        return new Product(name, price);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(product.getName(), this.name) && Objects.equals(product.getPrice(), this.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}