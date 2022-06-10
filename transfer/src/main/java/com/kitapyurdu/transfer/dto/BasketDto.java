package com.kitapyurdu.transfer.dto;
import com.kitapyurdu.stock.dto.ProductDto;
import java.io.Serializable;
import java.util.List;

public class BasketDto implements Serializable {
    public int basketId;
    public double totalAmount;
    public List<ProductDto> productList;
    public int status;

}
