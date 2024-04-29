package com.jwt.controller;

import com.jwt.controller.OrderController;
import com.jwt.model.Order;
import com.jwt.repo.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(null, "John Doe", "123 Main St", "Credit Card", "Standard Shipping", 2, BigDecimal.valueOf(100)));
        orders.add(new Order(null, "Jane Smith", "456 Elm St", "PayPal", "Express Shipping", 1, BigDecimal.valueOf(50)));

        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderController.getAllOrders();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetOrderById() {
        Order order = new Order(null, "John Doe", "123 Main St", "Credit Card", "Standard Shipping", 2, BigDecimal.valueOf(100));
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Optional<Order> result = orderController.getOrderById(1L);

        assertEquals(order, result.get());
    }

    @Test
    public void testCreateOrder() {
        Order order = new Order(null, "John Doe", "123 Main St", "Credit Card", "Standard Shipping", 2, BigDecimal.valueOf(100));
        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderController.createOrder(order);

        assertEquals(order, result);
    }

    @Test
    public void testUpdateOrder() {
        Order existingOrder = new Order(null, "John Doe", "123 Main St", "Credit Card", "Standard Shipping", 2, BigDecimal.valueOf(100));
        Order updatedOrder = new Order(null, "Jane Smith", "456 Elm St", "PayPal", "Express Shipping", 1, BigDecimal.valueOf(50));

        when(orderRepository.findById(1L)).thenReturn(Optional.of(existingOrder));
        when(orderRepository.save(existingOrder)).thenReturn(updatedOrder);

        Order result = orderController.updateOrder(1L, updatedOrder);

        assertEquals(updatedOrder, result);
    }

    @Test
    public void testDeleteOrder() {
        Order order = new Order(null, "John Doe", "123 Main St", "Credit Card", "Standard Shipping", 2, BigDecimal.valueOf(100));
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        String result = orderController.deleteOrder(1L);

        assertEquals("Order deleted successfully!", result);
        verify(orderRepository, times(1)).delete(order);
    }
}
