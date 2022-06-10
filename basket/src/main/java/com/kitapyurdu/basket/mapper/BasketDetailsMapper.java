package com.kitapyurdu.basket.mapper;

import com.kitapyurdu.basket.dto.BasketDetailsDto;

import com.kitapyurdu.basket.entity.Basket;

import com.kitapyurdu.basket.entity.BasketDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasketDetailsMapper extends IEntityMapper<BasketDetailsDto, BasketDetails>{
}
