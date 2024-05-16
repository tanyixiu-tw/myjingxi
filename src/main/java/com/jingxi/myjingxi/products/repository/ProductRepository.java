package com.jingxi.myjingxi.products.repository;

import com.jingxi.myjingxi.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE LOWER(p.sku) LIKE LOWER(CONCAT('%', :sku, '%'))")
    Page<Product> findBySku(String sku, Pageable pageable);
}