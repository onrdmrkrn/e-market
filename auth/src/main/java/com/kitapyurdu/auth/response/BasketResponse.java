package com.kitapyurdu.auth.response;

import com.kitapyurdu.auth.dto.BasketDto;
import java.io.Serializable;

public class BasketResponse extends BaseResponse implements Serializable {
    public BasketDto basket;
}
