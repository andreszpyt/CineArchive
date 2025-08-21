package com.cinearchive.controller;

import com.cinearchive.controller.request.CategoryRequest;
import com.cinearchive.controller.response.CategoryResponse;
import com.cinearchive.entity.Category;
import com.cinearchive.mapper.CategoryMapper;
import com.cinearchive.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories().stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public Optional<CategoryResponse> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) Optional.of(CategoryMapper.toCategoryResponse(category.get()));
        return Optional.empty();
    }

    @PostMapping
    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = categoryService.save(CategoryMapper.toCategory(categoryRequest));
        return CategoryMapper.toCategoryResponse(category);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCategory(@RequestBody CategoryRequest categoryRequest, @PathVariable Long id) {
        Category category = categoryService.PutCategory(CategoryMapper.toCategory(categoryRequest), id);
        return CategoryMapper.toCategoryResponse(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
