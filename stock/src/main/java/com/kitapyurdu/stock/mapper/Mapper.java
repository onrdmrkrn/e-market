package com.kitapyurdu.stock.mapper;
import com.kitapyurdu.stock.dto.CategoryDto;
import com.kitapyurdu.stock.dto.ProductDto;
import com.kitapyurdu.stock.entity.Category;
import com.kitapyurdu.stock.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public CategoryDto fromEntity(Category category) {
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.categoryId=category.getCategoryId();
        categoryDto.categoryName=category.getCategoryName();
        categoryDto.categoryDescription=category.getCategoryDescription();


        return categoryDto;
    }

    public Category toDto(CategoryDto categoryDto){
        Category category=new Category();
        category.setCategoryName(categoryDto.categoryName);
        category.setCategoryDescription(categoryDto.categoryDescription);
        category.setCategoryId(categoryDto.categoryId);
        return category;
    }
    public List<ProductDto> productListToDto(List<Product> productList) {
        List<ProductDto> productDtoList=new ArrayList<>();
        for (Product product:productList){
            ProductDto productDto=productFromEntity(product);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
    public ProductDto productFromEntity(Product product) {
        ProductDto productDto=new ProductDto();
        productDto.productId=product.getProductId();
        productDto.productAmount=product.getProductAmount();
        productDto.productName=product.getProductName();
        productDto.productDescprition=product.getProductDescprition();
        productDto.categoryId=product.getProductId();
        return productDto;
    }
    public Product productToDto(ProductDto productDto){
        Product product=new Product();
        product.setProductId(productDto.productId);
        product.setProductAmount(productDto.productAmount);
        product.setProductName(productDto.productName);
        product.setProductDescprition(productDto.productDescprition);;


        return product;
    }
}
