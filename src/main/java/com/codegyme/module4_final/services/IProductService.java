package com.codegyme.module4_final.services;

import com.codegyme.module4_final.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
}
