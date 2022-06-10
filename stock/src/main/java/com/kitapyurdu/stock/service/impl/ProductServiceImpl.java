package com.kitapyurdu.stock.service.impl;

import com.kitapyurdu.stock.dto.ProductDto;
import com.kitapyurdu.stock.entity.Category;
import com.kitapyurdu.stock.entity.Product;
import com.kitapyurdu.stock.exception.ProductAddException;
import com.kitapyurdu.stock.exception.ProductFindException;
import com.kitapyurdu.stock.repository.ProductRepository;
import com.kitapyurdu.stock.response.ProductResponse;
import com.kitapyurdu.stock.service.ProductService;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryServiceImpl categoryService;



    public Product deleteProduct(int productId){
        Product product=productRepository.findProductByProductId(productId);
        return product;
    }

    public Product productFind(int productId) {
        Product product = productRepository.findProductByProductId(productId);
        return product;
    }
    public List<Product> getProductByCategoryId(int categoryId){
        return productRepository.findAllByCategoryCategoryId(categoryId);
    }

    public ProductDto findProductByDto(int productId)throws ProductFindException {
        Product product=productFind(productId);
        if (product==null){
            throw new ProductFindException();
        }
        ProductDto productDto = new ProductDto();
        productDto.productAmount=product.getProductAmount();
        productDto.productDescprition=product.getProductDescprition();
        productDto.productName=product.getProductName();
        productDto.productId=product.getProductId();
        return productDto;
    }

    @SneakyThrows
    public ProductResponse addProduct(ProductDto dto) throws ProductAddException{
        Product product = new Product();
        product.setProductAmount(dto.productAmount);
        product.setProductDescprition(dto.productDescprition);
        product.setProductName(dto.productName);
        Category category=categoryService.findCategory(dto.categoryId);
        product.setCategory(category);
        product=productRepository.save(product);
        if (product==null){
            throw new ProductAddException();
        }
        ProductResponse productResponse = new ProductResponse();
        dto.categoryId = product.getProductId();
        dto.productDescprition = product.getProductDescprition();
        dto.productAmount = product.getProductAmount();
        productResponse.productDto = dto;
        return productResponse;
    }

    private ProductDto findProduct (int productId){
        Product  product= productRepository.findProductByProductId(productId);
        ProductDto productDto = new ProductDto();
        productDto.productAmount=product.getProductAmount();
        productDto.productDescprition=product.getProductDescprition();
        productDto.productName=product.getProductName();
        productDto.productId=product.getProductId();

        return  productDto;
    }
    private ProductResponse generatedProductResult(ProductDto toResource) {

        ProductResponse productResponse=new ProductResponse();
        productResponse.productDto=toResource;
        return productResponse;
    }
}
