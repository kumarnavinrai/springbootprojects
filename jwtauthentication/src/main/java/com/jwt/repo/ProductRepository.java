package com.jwt.repo;

import com.jwt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom query methods here if needed

    Product getProductByProductName(String name);

    Product getProductByPrice(Double price);

    Product getProductByIdAndProductName(Long id, String name);


    @Query("select p from Product p")
    List<Product> getAllProductsUsingJPQL();


    @Query("select p from Product p where p.productName =:n")
    List<Product> getAllProductsUsingJPQLQueryParam(@Param("n") String name);

    //@Query("select sum(p.price) as sum from Product p where p.name =:n")
//    @Query("select count(p.price) as count from Product p where p.name =:n")
    @Query("select sum(case when p.productName = :n then p.price else 0.0 end ) as sumOfProducts,\n" +
            "\t sum(case when p.productName = :n then p.price else 0.0 end ) as sumOfProducts2\n from Product p ")
    Map<String ,Double> getAllProductsPriceUsingJPQLQueryParam(@Param("n") String name);
    @Query(value ="select * from Product ", nativeQuery = true)
    List<Product> getAllProductsUsingNative();
}
