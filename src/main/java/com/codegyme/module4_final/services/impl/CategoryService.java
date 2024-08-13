package com.codegyme.module4_final.services.impl;

import com.codegyme.module4_final.models.Category;
import com.codegyme.module4_final.repositories.ICategoryRepository;
import com.codegyme.module4_final.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
