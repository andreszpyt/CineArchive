package com.cinearchive.mapper;

import com.cinearchive.controller.request.CategoryRequest;
import com.cinearchive.controller.response.CategoryResponse;
import com.cinearchive.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public Category toCategory(CategoryRequest request){
        return Category.builder()
                .name(request.name())
                .build();
    }

    public CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
