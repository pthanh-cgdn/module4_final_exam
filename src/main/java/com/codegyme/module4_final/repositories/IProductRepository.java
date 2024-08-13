package com.codegyme.module4_final.repositories;

import com.codegyme.module4_final.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
