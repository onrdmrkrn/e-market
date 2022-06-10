package com.kitapyurdu.stock.dto;

import com.kitapyurdu.stock.entity.Category;

import java.io.Serializable;

public class ProductDto implements Serializable {
    public int productId;
    public String productName;
    public String productDescprition;
    public int productAmount;

    public int categoryId;
}
