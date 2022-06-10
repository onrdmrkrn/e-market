package com.kitapyurdu.stock.repository;
import com.kitapyurdu.stock.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    public Category findCategoryByCategoryId(int categoryId);
}
