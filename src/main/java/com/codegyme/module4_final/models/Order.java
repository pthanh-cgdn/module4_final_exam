package com.codegyme.module4_final.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public Order() {
    }

    public Order(Long id, LocalDate date, Integer quantity, Product product) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
