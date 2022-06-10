package com.kitapyurdu.basket.service;

import com.hazelcast.core.HazelcastInstance;
import com.kitapyurdu.basket.dto.*;
import com.kitapyurdu.basket.entity.Basket;
import com.kitapyurdu.basket.entity.BasketDetails;
import com.kitapyurdu.basket.exception.findBasketException;
import com.kitapyurdu.basket.mapper.BasketDetailsMapper;
import com.kitapyurdu.basket.mapper.BasketMapper;
import com.kitapyurdu.basket.repository.BasketDetailsRepostiory;
import com.kitapyurdu.basket.repository.BasketRepository;
import com.kitapyurdu.basket.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class BasketService {



    @Autowired
    BasketRepository basketRepository;
    @Autowired
    BasketMapper basketMapper;

    @Autowired
    public Map<String, Basket> basketMap;
    @Autowired
    BasketDetailsMapper basketDetailsMapper;
    @Autowired
    BasketDetailsRepostiory basketDetailsRepostiory;

    private final HazelcastInstance hazelcastInstance;


    public BasketService(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public ProductResponse sendRequestProductService(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9112/product/productFind/" + productId, ProductResponse.class);
    }

    public UserDto findUserById(int userId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9061/user/find/" + userId, UserDto.class);
    }

    public PaymentResponse sendRequestPaymentId(int paymentId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("" + paymentId, PaymentResponse.class);
    }

   public String addProductToBasket(BasketDetailsDto dto){
        ProductResponse productResponse = sendRequestProductService(dto.productId);
        ProductDto productDto = productResponse.productDto;
        BasketDetails basketDetails = new BasketDetails();
        Basket basket = findBasketByuserIdForActivity(dto.userId, 1);
        basketDetails.setBasket(basket);
        basketDetails.setProductId(productDto.productId);
        basketDetails.setCount(dto.count);
        basketDetailsRepostiory.save(basketDetails);
        basket.setTotalAmount(setAmount(basket, dto , productDto));
        basketRepository.save(basket);
        return "ürün sepete eklendi";

   }
   public List<ProductDto> getBasket(GetBasketDto getBasketDto){
        Basket basket = basketRepository.findBasketsByUserIdAndStatus(getBasketDto.userId, 1);
        List<ProductDto> productDtos = new ArrayList<>();
        List<BasketDetails> basketDetails = basketDetailsRepostiory.findBasketDetailsByBasket(basket);
        for (BasketDetails basketDetail : basketDetails){
            ProductResponse productResponse = sendRequestProductService(basketDetail.getProductId());

            productDtos.add(productResponse.productDto);

        }
        return productDtos;

   }
    public double setAmount(Basket basket, BasketDetailsDto dto, ProductDto product){


        double amount = 0;
        for (int i = 0; i < dto.count; i++) {
            amount = amount + product.productAmount;

        }
         basket.setTotalAmount(basket.getTotalAmount() + amount);
        return basket.getTotalAmount();

    }
    public Basket findBasketByuserIdForActivity(int userId, int basketActivity){
        Basket basket = basketRepository.findBasketsByUserIdAndStatus(userId,basketActivity);
        if (basket == null){
            basket = newBasket(userId);
        }
        return basket;
    }

    public Basket newBasket( int userId){
        UserDto userDto = findUserById(userId);
        Basket basket = new Basket();
        basket.setUserId(userDto.userId);
        basket.setStatus(1);
        basketRepository.save(basket);

        return basket;
    }

    public ResponseEntity<BasketDto> getBasketByBasketId(int basketId) throws findBasketException {
        Basket basket = getSession(String.valueOf(basketId));
        if (basket == null) {
            basket = basketRepository.findBasketByBasketId(basketId);
            if (basket == null) {
                throw new findBasketException();
            }
            addSession(String.valueOf(basket.getBasketId()),basket);
        }
        return ResponseEntity.ok(basketMapper.toResource(basket));
    }

    public Basket getSession(String key) {
        Map<String, Basket> basketMap = hazelcastInstance.getMap("basketMap");
        return basketMap.get(key);
    }

    public void addSession(String key, Basket order) {
        Map<String, Basket> basketMap = hazelcastInstance.getMap("basketMap");
        basketMap.put(key, order);
    }

    public BasketResponse updateBasket(BasketDto basketDto) {
        BasketResponse basketResponse = new BasketResponse();
        Basket basket = basketRepository.findBasketByBasketId(basketDto.basketId);
        basket.setStatus(basketDto.status);
        basket = basketRepository.save(basket);
        return basketResponse;

    }

}
