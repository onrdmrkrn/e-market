package com.kitapyurdu.stock.repository;


import com.kitapyurdu.stock.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product findProductByProductId(int productId);
    public List<Product> findAllByCategoryCategoryId(int categoryId);
    public Product deleteByProductId(int productId);
}
