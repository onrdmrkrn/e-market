package com.kitapyurdu.stock.controller;

import com.kitapyurdu.stock.dto.ProductDto;
import com.kitapyurdu.stock.exception.ProductAddException;
import com.kitapyurdu.stock.response.Meta;
import com.kitapyurdu.stock.response.ProductResponse;
import com.kitapyurdu.stock.service.ProductService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping("/productAdd")
    public ProductResponse productAdd(@RequestBody ProductDto dto) throws ProductAddException{
        return productService.addProduct(dto);
    }


    @GetMapping("/productDelete/{productId}")
    public ProductResponse productDelete(@PathVariable(value = "productId") String productId) {
        ProductResponse productResponse = new ProductResponse();
        Meta meta = new Meta();
            meta.errorCode = 200;
            meta.errorDesc = "Ürün silme başarılı.";

        productResponse.meta = meta;
        return productResponse;
    }

    @SneakyThrows
    @GetMapping("/productFind/{productId}")
    public ProductResponse productFind(@PathVariable(value = "productId") String productId) {
        ProductResponse productResponse = new ProductResponse();
        Meta meta = new Meta();
        ProductDto productDto=productService.findProductByDto(Integer.parseInt(productId));
        meta.errorCode = 200;
        meta.errorDesc = "Ürün bulma başarılı. Bulunan Ürün = "+" "+productId;
        productResponse.productDto=productDto;
        productResponse.meta = meta;
        return productResponse;
    }

}// delete başarılı diyor ancak databaseden silmiyor..