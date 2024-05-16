package com.jingxi.myjingxi.products.service;

import com.jingxi.myjingxi.products.entity.Product;
import com.jingxi.myjingxi.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> findBySkuWithPagination(String sku, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findBySku(sku, pageable);
    }
}
