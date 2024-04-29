package com.jwt.controller;

import com.jwt.model.Product;

import com.jwt.repo.ProductRepository;
import com.jwt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    // Read all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Read a product by ID
    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }


    @GetMapping("/name/{name}")
    public Product findById(@PathVariable String name) {
        return productService.getProductByProductName(name);
    }

    // Update a product
    @PutMapping("/products/{id}")
    public Product updateProduct(@Valid @PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setProductName(productDetails.getProductName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    // Delete a product
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        productRepository.delete(product);
        return "Product deleted successfully!";
    }

    @GetMapping("/jpql")
    public List<Product> jpqlFindAll()
    {
        return productService.getAllJPQL();
    }

    @GetMapping("/jpqlq/{name}")
    public List<Product> jpqlFindAllJPQL(@PathVariable String name)
    {
        return productService.getAllJPQLQueryParam(name);
    }

    @GetMapping("/jpqlSum/{name}")
    public Map<String,Double> jpqlFindAllProductSumJPQL(@PathVariable String name)
    {
        return productService.getSumOfAllProductWithParticularNameJPQLQueryParam(name);
    }
    @GetMapping("/native")
    public List<Product> jpqlFindAllNative()
    {
        return productService.getAllJPQLNative();
    }
}
