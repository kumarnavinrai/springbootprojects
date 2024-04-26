package com.jwt.controller;

import com.jwt.model.Order;
import com.jwt.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // Create a new order
    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderRepository.save(order);
    }

    // Read all orders
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Read an order by ID
    @GetMapping("/orders/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id);
    }

    // Update an order
    @PutMapping("/orders/{id}")
    public Order updateOrder(@Valid @PathVariable Long id, @RequestBody Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        order.setCustomerName(orderDetails.getCustomerName());
        order.setAddress(orderDetails.getAddress());
        order.setPaymentMethod(orderDetails.getPaymentMethod());
        order.setShippingMethod(orderDetails.getShippingMethod());
        order.setQuantity(orderDetails.getQuantity());
        order.setOrderAmount(orderDetails.getOrderAmount());
        return orderRepository.save(order);
    }

    // Delete an order
    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        orderRepository.delete(order);
        return "Order deleted successfully!";
    }
}
