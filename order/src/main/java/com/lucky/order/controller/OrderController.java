package com.lucky.order.controller;

import com.lucky.order.dto.OrderDTO;
import com.lucky.order.entity.Order;
import com.lucky.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

    @PutMapping
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.update(orderDTO);
    }

    @DeleteMapping
    public void deleteOrder(@RequestBody OrderDTO orderDTO) {
        orderService.delete(orderDTO);
    }
}
