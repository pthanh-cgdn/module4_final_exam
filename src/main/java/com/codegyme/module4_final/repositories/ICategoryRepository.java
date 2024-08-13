package com.codegyme.module4_final.repositories;

import com.codegyme.module4_final.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
