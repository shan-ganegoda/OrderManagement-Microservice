package com.lucky.order.service;

import com.lucky.order.dto.OrderDTO;
import com.lucky.order.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrders();

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO update(OrderDTO orderDTO);

    void delete(OrderDTO orderDTO);
}
