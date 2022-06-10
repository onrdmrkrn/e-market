package com.kitapyurdu.basket.response;

import com.kitapyurdu.basket.dto.BasketDto;

import java.io.Serializable;
import java.util.List;

public class BasketListResponse extends BaseResponse implements Serializable {
    public List<BasketDto> basketDtoList;
}
