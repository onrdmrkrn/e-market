package com.kitapyurdu.basket.mapper;

import com.kitapyurdu.basket.dto.ProductDto;
import com.kitapyurdu.basket.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends IEntityMapper<ProductDto, Product> {
}
