package com.kitapyurdu.stock.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Ürün")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Ürün_anahtarı", nullable = false , updatable = false, unique = true)
    private int productId;

    @Column(name = "Ürün_adı", nullable = false, unique = true)
    private String productName;

    @Column(name = "Ürün_açıklaması", nullable = false)
    private String productDescprition;

    @Column(name = "Ürün_fiyatı" , nullable = false)
    private int productAmount;


    @ManyToOne
    private Category category;

}
