package com.jingxi.myjingxi.products;

import com.jingxi.myjingxi.exception.ErrorResponse;
import com.jingxi.myjingxi.products.entity.Product;
import com.jingxi.myjingxi.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getProductsBySku(@RequestParam String sku, @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "15") int size) {
        if (size > 30) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "the page size cannot exceed 30");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        Page<Product> products = productService.findBySkuWithPagination(sku, page, size);

        if (products.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "cannot find the product");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
