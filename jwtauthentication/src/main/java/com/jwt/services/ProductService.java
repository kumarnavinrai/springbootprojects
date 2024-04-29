package com.jwt.services;

import com.jwt.model.Product;
import com.jwt.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductByProductName(String name){
        return   productRepository.getProductByProductName(name);

    }

    public List<Product> getAllJPQL(){

        return productRepository.getAllProductsUsingJPQL();
    }

    public List<Product> getAllJPQLQueryParam(String name){

        return productRepository.getAllProductsUsingJPQLQueryParam(name);
    }
    public Map<String , Double> getSumOfAllProductWithParticularNameJPQLQueryParam(String name){

        return productRepository.getAllProductsPriceUsingJPQLQueryParam(name);
    }

    public List<Product> getAllJPQLNative(){

        return productRepository.getAllProductsUsingNative();
    }

}
