package com.jwt.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotEmpty(message = "Customer name cannot be empty")
    @Size(min = 2, message = "Customer name must be at least 2 characters")
    private String customerName;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotEmpty(message = "Payment method cannot be empty")
    private String paymentMethod;

    @NotEmpty(message = "Shipping method cannot be empty")
    private String shippingMethod;

    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;

    @NotNull(message = "Order amount cannot be null")
    private BigDecimal orderAmount;

    // More properties as per your project requirements

    public Order() {
    }

    public Order(Product product, String customerName, String address, String paymentMethod, String shippingMethod, Integer quantity, BigDecimal orderAmount) {
        this.product = product;
        this.customerName = customerName;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.quantity = quantity;
        this.orderAmount = orderAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    // Add more getters and setters as needed

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", quantity=" + quantity +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
