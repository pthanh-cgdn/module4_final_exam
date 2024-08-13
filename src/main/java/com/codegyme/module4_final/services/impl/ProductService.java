package com.codegyme.module4_final.services.impl;

import com.codegyme.module4_final.models.Product;
import com.codegyme.module4_final.repositories.IProductRepository;
import com.codegyme.module4_final.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
