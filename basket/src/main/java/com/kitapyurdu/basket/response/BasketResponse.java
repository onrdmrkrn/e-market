package com.kitapyurdu.basket.response;

import com.kitapyurdu.basket.dto.BasketDto;


import java.io.Serializable;

public class BasketResponse extends BaseResponse implements Serializable {
    public BasketDto basket;
}
