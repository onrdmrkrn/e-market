package com.kitapyurdu.transfer.response;

import com.kitapyurdu.transfer.dto.BasketDto;

import java.io.Serializable;

public class BasketResponse extends BaseResponse implements Serializable {
    public BasketDto basket;
}
