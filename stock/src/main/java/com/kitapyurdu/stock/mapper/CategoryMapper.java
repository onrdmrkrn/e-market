package com.kitapyurdu.stock.mapper;

import com.kitapyurdu.stock.dto.CategoryDto;
import com.kitapyurdu.stock.entity.Category;
import com.kitapyurdu.stock.service.CategoryService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring" , uses = CategoryService.class)
public interface CategoryMapper extends IEntityMapper <CategoryDto, Category> {
}
