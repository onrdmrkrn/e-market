package com.kitapyurdu.basket.dto;


import java.io.Serializable;
import java.util.List;

public class BasketDto implements Serializable {
    public int basketId;
    public double totalAmount;
    public List<BasketDetailsDto> basketDetailList;
    public int userId;
    public int status;
}
