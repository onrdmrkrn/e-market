package com.kitapyurdu.stock.controller;

import com.kitapyurdu.stock.dto.CategoryDto;
import com.kitapyurdu.stock.entity.Category;
import com.kitapyurdu.stock.exception.CategoryAddException;
import com.kitapyurdu.stock.response.CategoryListResponse;
import com.kitapyurdu.stock.response.CategoryResponse;
import com.kitapyurdu.stock.response.Meta;
import com.kitapyurdu.stock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/add")
    public CategoryResponse add(@RequestBody CategoryDto dto) throws CategoryAddException {
      return categoryService.addCategory(dto);
    }

    @lombok.SneakyThrows
    @GetMapping("/findCategory/{categoryId}")
    public ResponseEntity<CategoryDto> findCategory(@PathVariable(value = "categoryId") String categoryId) {
        return categoryService.findCategoryByDto(Integer.parseInt(categoryId));

    }

    @GetMapping("/categoryGetAll")
    public CategoryListResponse categoryGetAll() {
        CategoryListResponse categoryListResponse = new CategoryListResponse();
        Meta meta = new Meta();
        List<CategoryDto> category = categoryService.getAllCategory();
        CategoryResponse categoryResponse = new CategoryResponse();
        if (category != null) {
            meta.errorCode = 200;
            meta.errorDesc = "Tüm kategoriler bulundu.";
            categoryListResponse.categoryDtoList = category;
        } else {
            meta.errorCode = 4001;
            meta.errorDesc = "Kategoriler bulunamadı.";
        }
        categoryResponse.meta = meta;
        return categoryListResponse;
    }
}




