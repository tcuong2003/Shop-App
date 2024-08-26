package org.tc.backend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.tc.backend.components.LocalizationUtils;
import org.tc.backend.dtos.CategoryDTO;
import org.tc.backend.models.Category;
import org.tc.backend.responses.UpdateCategoryResponse;
import org.tc.backend.services.CategoryService;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final MessageSource messageSource;
    private final LocaleResolver localResolver;
    private final LocalizationUtils localizationUtils;

    @PostMapping("/post")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok("create category successfully");
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "limit") int limit
    ) {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCategoryResponse> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDTO categoryDTO,
            HttpServletRequest request) {
        categoryService.updateCategory(id, categoryDTO);
        Locale locale = localResolver.resolveLocale(request);
        return ResponseEntity.ok(
                UpdateCategoryResponse.builder()
                        .message(messageSource.getMessage("category.update_category.update_successfully", null, locale))
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("delete category successfully");
    }

}
