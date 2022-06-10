package com.kitapyurdu.interaction.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productDescprition;
    @ManyToOne
    @JoinColumn(name = "favoriteId")
    private Favourites favourites;
    @OneToMany(mappedBy = "product")
    private List<Comments> commentsList;

    public Product() {
    }

    public Product(int productId, String productName, String productDescprition, Favourites favourites, List<Comments> commentsList) {
        this.productId = productId;
        this.productName = productName;
        this.productDescprition = productDescprition;
        this.favourites = favourites;
        this.commentsList = commentsList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescprition() {
        return productDescprition;
    }

    public void setProductDescprition(String productDescprition) {
        this.productDescprition = productDescprition;
    }

    public Favourites getFavourites() {
        return favourites;
    }

    public void setFavourites(Favourites favourites) {
        this.favourites = favourites;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }
}