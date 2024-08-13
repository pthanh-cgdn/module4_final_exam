package com.codegyme.module4_final.services;

import com.codegyme.module4_final.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
