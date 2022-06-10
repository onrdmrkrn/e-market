package com.kitapyurdu.basket.controller;

import com.kitapyurdu.basket.dto.BasketDetailsDto;
import com.kitapyurdu.basket.dto.BasketDto;
import com.kitapyurdu.basket.dto.GetBasketDto;
import com.kitapyurdu.basket.dto.ProductDto;
import com.kitapyurdu.basket.exception.findBasketException;
import com.kitapyurdu.basket.response.BasketResponse;
import com.kitapyurdu.basket.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket")
public class BasketController {
    @Autowired
    BasketService basketService;

    @PostMapping("/addBasket")
    public String addProductToBasket(@RequestBody BasketDetailsDto dto){
        return basketService.addProductToBasket(dto);
    }
    @PostMapping("/getBasket")
    public List<ProductDto> addProductToBasket(@RequestBody GetBasketDto dto){
        return basketService.getBasket(dto);
    }

    @GetMapping("getBasket/{basketId}")
    public ResponseEntity<BasketDto> getBasketByBasketId(@PathVariable (value = "basketId")String basketId) throws findBasketException {
        return basketService.getBasketByBasketId(Integer.parseInt(basketId));
    }

    @PostMapping("/updateBasket")
    public BasketResponse updateBasket(@RequestBody BasketDto basketDto){
      return basketService.updateBasket(basketDto);
  }



}
