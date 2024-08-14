package com.lucky.order.util.mapper;

import com.lucky.order.dto.OrderDTO;
import com.lucky.order.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    List<OrderDTO> orderToOrderDto(List<Order> orders);

    Order orderDtoToOrder(OrderDTO orderDTO);
}
