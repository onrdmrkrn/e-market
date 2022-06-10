package com.kitapyurdu.basket.repository;

import com.kitapyurdu.basket.entity.Basket;

import com.kitapyurdu.basket.entity.BasketDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BasketRepository extends JpaRepository<Basket,Integer> {
    public Basket findBasketByBasketId(int basketId);
    public Basket findBasketsByUserIdAndStatus (int userId, int status);

}
