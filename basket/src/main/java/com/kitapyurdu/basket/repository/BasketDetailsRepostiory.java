package com.kitapyurdu.basket.repository;

import com.kitapyurdu.basket.dto.BasketDetailsDto;
import com.kitapyurdu.basket.entity.Basket;
import com.kitapyurdu.basket.entity.BasketDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketDetailsRepostiory extends JpaRepository<BasketDetails,Integer> {
    List<BasketDetails> findBasketDetailsByBasket (Basket basket);
}
