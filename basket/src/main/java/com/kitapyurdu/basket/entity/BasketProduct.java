package com.kitapyurdu.basket.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BasketProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketProductId;

    private int count;

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "basketId")
    private Basket basket;

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }



    public int getBasketProductId() {
        return basketProductId;
    }

    public void setBasketProductId(int basketProductId) {
        this.basketProductId = basketProductId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
