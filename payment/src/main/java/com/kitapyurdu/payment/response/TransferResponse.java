package com.kitapyurdu.payment.response;

import com.kitapyurdu.payment.dto.TransferDto;

import java.io.Serializable;

public class TransferResponse extends BaseResponse implements Serializable {
    public TransferDto transfer;
}
