package com.kitapyurdu.basket.mapper;

import com.kitapyurdu.basket.dto.BasketDto;
import com.kitapyurdu.basket.entity.Basket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasketMapper extends IEntityMapper<BasketDto, Basket>{
}
