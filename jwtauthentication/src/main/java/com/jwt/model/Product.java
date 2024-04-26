package com.jwt.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotEmpty(message = "Product name cannot be empty")
    @Size(min = 4, message = "Product name must be min 4 character")
    @Pattern(regexp = "^[a-zA-Z0-9]+[0-9]{2}[a-zA-Z]+[0-9]$", message = "Product name must follow the format redcap22size5discount")
    private String productName;

    @NotEmpty(message = "Description name cannot be empty")
    @Size( min = 10, max = 30, message = "Description must be min 10 and max 30 character")
    private String description;

    @NotNull(message = "Price cannot be null")
    private Double price;

    // More properties as per your project requirements

    public Product() {
    }

    public Product(User user, String productName, String description, Double price) {
        this.user = user;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Add more getters and setters as needed

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", user=" + user +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
