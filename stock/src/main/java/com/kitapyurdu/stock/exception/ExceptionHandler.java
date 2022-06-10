package com.kitapyurdu.stock.exception;
import com.kitapyurdu.stock.response.CategoryResponse;
import com.kitapyurdu.stock.response.Meta;
import com.kitapyurdu.stock.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> addException(CategoryAddException exception, WebRequest webRequest) {
        CategoryResponse categoryResponse=new CategoryResponse();
        Meta response = new Meta();
        response.errorCode = 6112;
        response.errorDesc = " Kategori, eklemede sistemsel bir hata oluştu.";
        categoryResponse.meta=response;
        ResponseEntity<Object> entity = new ResponseEntity<>(categoryResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productAddException(ProductAddException exception, WebRequest webRequest) {
        ProductResponse productResponse=new ProductResponse();
        Meta response = new Meta();
        response.errorCode = 6112;
        response.errorDesc = " Ürün, eklemede sistemsel bir hata oluştu.";
        productResponse.meta=response;
        ResponseEntity<Object> entity = new ResponseEntity<>(productResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> categoryFindException(CategoryFindException exception, WebRequest webRequest) {
        CategoryResponse categoryResponse=new CategoryResponse();
        Meta response = new Meta();
        response.errorCode = 6112;
        response.errorDesc = " Kategori, bulmada sistemsel bir hata oluştu.";
        categoryResponse.meta=response;
        ResponseEntity<Object> entity = new ResponseEntity<>(categoryResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productFindExeption(ProductFindException exception, WebRequest webRequest) {
        ProductResponse productResponse=new ProductResponse();
        Meta response = new Meta();
        response.errorCode = 6112;
        response.errorDesc = " Ürün, bulmada sistemsel bir hata oluştu.";
        productResponse.meta=response;
        ResponseEntity<Object> entity = new ResponseEntity<>(productResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}
