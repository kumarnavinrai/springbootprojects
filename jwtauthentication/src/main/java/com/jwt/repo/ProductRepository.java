package com.jwt.repo;

import com.jwt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom query methods here if needed

    Product getProductByName(String name);

    Product getProductByPrice(Double price);

    Product getProductByIdAndName(Long id, String name);
}
