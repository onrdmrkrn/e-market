package com.kitapyurdu.basket.entity;

import com.kitapyurdu.basket.dto.BasketDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Basket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketId;

    private double totalAmount= 0.0; // status ekle

    private int status;

    private int userId;

    @OneToMany(mappedBy = "basket", fetch = FetchType.EAGER)
    List<BasketDetails> basketDetailList;




}
