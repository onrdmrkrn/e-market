package com.kitapyurdu.basket.entity;

import com.kitapyurdu.basket.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productDescprition;
    private int productPrice;

    public static ProductDto toDto(Product product){
        ProductDto dto=new ProductDto();
        dto.productId=product.getProductId();
        dto.productAmount=product.getProductPrice();
        dto.productDescprition=product.getProductDescprition();
        dto.productName=product.getProductName();

        return dto;
    }

    public static Product toEntity(ProductDto dto){
        Product product=new Product();
        product.setProductId(dto.productId);
        product.setProductDescprition(dto.productDescprition);
        product.setProductPrice(dto.productAmount);
        product.setProductName(dto.productName);
        return product;
    }


}
