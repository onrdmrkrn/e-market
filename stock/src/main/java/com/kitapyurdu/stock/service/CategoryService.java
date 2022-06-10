package com.kitapyurdu.stock.service;

import com.kitapyurdu.stock.dto.CategoryDto;
import com.kitapyurdu.stock.entity.Category;
import com.kitapyurdu.stock.exception.CategoryAddException;
import com.kitapyurdu.stock.exception.CategoryFindException;
import com.kitapyurdu.stock.response.CategoryResponse;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.core.Response;
import java.util.List;

public interface CategoryService {

    public CategoryResponse addCategory(CategoryDto categoryDto) throws CategoryAddException;
    public ResponseEntity<CategoryDto> findCategoryByDto (int categoryId) throws CategoryFindException;

    public List<Category> getCategoryList();



    List<CategoryDto> getAllCategory();
}
