package com.kitapyurdu.stock.dto;

import com.kitapyurdu.stock.entity.Product;

import java.io.Serializable;
import java.util.List;

public class CategoryDto implements Serializable {
    public int categoryId;
    public String categoryName;
    public String categoryDescription;

    public List<ProductDto> productList;
}
