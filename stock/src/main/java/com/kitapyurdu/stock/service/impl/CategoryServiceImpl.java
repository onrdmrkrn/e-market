package com.kitapyurdu.stock.service.impl;
import com.hazelcast.core.HazelcastInstance;
import com.kitapyurdu.stock.dto.CategoryDto;
import com.kitapyurdu.stock.entity.Category;
import com.kitapyurdu.stock.exception.CategoryAddException;
import com.kitapyurdu.stock.exception.CategoryFindException;
import com.kitapyurdu.stock.mapper.CategoryMapper;
import com.kitapyurdu.stock.repository.CategoryRepository;
import com.kitapyurdu.stock.response.CategoryResponse;
import com.kitapyurdu.stock.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryRepository categoryRepository;


    @Autowired
    public Map<String,Category> categoryMap;
    private final HazelcastInstance hazelcastInstance;

    public CategoryServiceImpl(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public CategoryResponse addCategory(CategoryDto categoryDto) throws CategoryAddException{

        Category category = new Category();
        category.setCategoryName(categoryDto.categoryName);
        category.setCategoryDescription(categoryDto.categoryDescription);
        category=categoryRepository.save(category);
        if (category==null){
            throw new CategoryAddException();
        }
        categoryDto.categoryDescription = category.getCategoryDescription();
        categoryDto.categoryName = category.getCategoryName();
        categoryDto.categoryId = category.getCategoryId();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.categoryDto = categoryDto;
        return  categoryResponse;

    }

    private CategoryResponse generatedCategoryResult(CategoryDto toResource) {
        CategoryResponse categoryResponse=new CategoryResponse();
        categoryResponse.categoryDto=toResource;
        return categoryResponse;
    }


    public ResponseEntity<CategoryDto> findCategoryByDto (int categoryId) throws CategoryFindException{
        Category category=getSession(String.valueOf(categoryId));
        if (category==null){
            category=categoryRepository.findCategoryByCategoryId(categoryId);
            if (category==null){
                System.out.println("Databasede kayıtlı kategori bulunamadı.");
            }
            addSession(String.valueOf(category.getCategoryId()), category);
        }
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.categoryId=category.getCategoryId();
        categoryDto.categoryName=category.getCategoryName();
        categoryDto.categoryDescription=category.getCategoryDescription();
        return ResponseEntity.ok(categoryDto);
    }




    public Category findCategory(int categoryId) throws CategoryFindException {
        Category category=categoryRepository.findCategoryByCategoryId(categoryId);

        return  category;
    }

    public Category getSession(String key) {
        Map<String, Category> basketMap = hazelcastInstance.getMap("categoryMap");
        return basketMap.get(key);
    }

    public void addSession(String key, Category category) {
        Map<String, Category> basketMap = hazelcastInstance.getMap("categoryMap");
        basketMap.put(key, category);
    }

    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryMapper.toResource(getCategoryList());
    }
}
