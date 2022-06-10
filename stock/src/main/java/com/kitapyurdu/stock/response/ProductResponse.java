package com.kitapyurdu.stock.response;

import com.kitapyurdu.stock.dto.ProductDto;
import com.kitapyurdu.stock.entity.Product;
import org.mapstruct.BeanMapping;
import org.springframework.context.annotation.Bean;


import java.io.Serializable;

public class ProductResponse extends BaseResponse implements Serializable {
    public ProductDto productDto;
}
