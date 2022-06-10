package com.kitapyurdu.stock.response;

import com.kitapyurdu.stock.dto.CategoryDto;

import java.io.Serializable;
import java.util.List;

public class CategoryListResponse extends BaseResponse implements Serializable {
    public List<CategoryDto> categoryDtoList;
}
