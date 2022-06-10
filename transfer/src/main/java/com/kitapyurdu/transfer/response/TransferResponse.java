package com.kitapyurdu.transfer.response;

import com.kitapyurdu.transfer.dto.TransferDto;

import java.io.Serializable;

public class TransferResponse extends BaseResponse implements Serializable {
    public TransferDto transfer;
}
