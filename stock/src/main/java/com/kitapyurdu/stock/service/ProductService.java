package com.kitapyurdu.stock.service;

import com.kitapyurdu.stock.dto.ProductDto;
import com.kitapyurdu.stock.entity.Product;
import com.kitapyurdu.stock.exception.ProductAddException;
import com.kitapyurdu.stock.exception.ProductFindException;
import com.kitapyurdu.stock.response.ProductResponse;

public interface ProductService {

    public ProductResponse addProduct(ProductDto dto) throws ProductAddException;

    public ProductDto findProductByDto(int productId)throws ProductFindException;
}
