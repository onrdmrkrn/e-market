package com.kitapyurdu.basket.response;

import com.kitapyurdu.basket.dto.ProductDto;
import java.io.Serializable;

public class ProductResponse extends BaseResponse implements Serializable {
    public ProductDto productDto;
}
