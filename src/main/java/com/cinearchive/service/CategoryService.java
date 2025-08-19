package com.cinearchive.service;

import com.cinearchive.entity.Category;
import com.cinearchive.repository.CategoryRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRespository categoryRespository;

    public List<Category> getAllCategories() {
        return categoryRespository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRespository.findById(id);
    }

    public Category save(Category category) {
        return categoryRespository.save(category);
    }

    public void deleteById(Long id) {
        categoryRespository.deleteById(id);
    }

    public Category PutCategory(Category category, Long id) {
        category.setId(id);
        return categoryRespository.save(category);
    }
}
