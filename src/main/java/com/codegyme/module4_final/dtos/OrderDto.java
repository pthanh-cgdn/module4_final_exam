package com.codegyme.module4_final.dtos;

import com.codegyme.module4_final.models.Product;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;


public class OrderDto implements Validator {
    private Long id;
    @NotNull
    @Future
    private LocalDate date;
    @NotNull
    @Min(1)
    private Integer quantity;
    private Product product;

    public OrderDto() {
    }

    public OrderDto(Long id, LocalDate date, Integer quantity, Product product) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
