package com.jwt.controller;

import com.jwt.model.Product;
import com.jwt.repo.ProductRepository;
import com.jwt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    // Read all products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok().body(products);
    }

    // Read a product by ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findById(@PathVariable String name) {
        Product product = productService.getProductByProductName(name);
        return ResponseEntity.ok().body(product);
    }

    // Update a product
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setProductName(productDetails.getProductName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok().body(updatedProduct);
    }

    // Delete a product
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return ResponseEntity.ok().body("Product deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/jpql")
    public ResponseEntity<List<Product>> jpqlFindAll() {
        List<Product> products = productService.getAllJPQL();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/jpqlq/{name}")
    public ResponseEntity<List<Product>> jpqlFindAllJPQL(@PathVariable String name) {
        List<Product> products = productService.getAllJPQLQueryParam(name);
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/jpqlSum/{name}")
    public ResponseEntity<Map<String, Double>> jpqlFindAllProductSumJPQL(@PathVariable String name) {
        Map<String, Double> result = productService.getSumOfAllProductWithParticularNameJPQLQueryParam(name);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/native")
    public ResponseEntity<List<Product>> jpqlFindAllNative() {
        List<Product> products = productService.getAllJPQLNative();
        return ResponseEntity.ok().body(products);
    }
}
