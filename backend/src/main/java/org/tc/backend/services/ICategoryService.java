package org.tc.backend.services;

import org.tc.backend.dtos.CategoryDTO;
import org.tc.backend.models.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(CategoryDTO category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Long id, CategoryDTO category);
    void deleteCategory(Long id);

}
