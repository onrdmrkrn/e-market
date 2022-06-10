package com.kitapyurdu.stock.response;

import com.kitapyurdu.stock.dto.CategoryDto;

import java.io.Serializable;

public class CategoryResponse extends BaseResponse implements Serializable {
    public CategoryDto categoryDto;
}
