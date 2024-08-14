package com.lucky.order.service;

import com.lucky.order.dto.OrderDTO;
import com.lucky.order.entity.Order;
import com.lucky.order.repository.OrderRepository;
import com.lucky.order.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceIMPL implements OrderService{

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<OrderDTO> getOrders() {

        List<Order> orders = orderRepository.findAll();

        if(!orders.isEmpty()){
            List<OrderDTO> orderDTO = objectMapper.orderToOrderDto(orders);
            return orderDTO;
        }else{
            return null;
        }
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        if(orderDTO != null){
            Order order = objectMapper.orderDtoToOrder(orderDTO);
            orderRepository.save(order);
            return orderDTO;
        }else{
            return null;
        }
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        if(orderDTO != null){
            if(orderRepository.existsById(orderDTO.getId())){
                Order order = objectMapper.orderDtoToOrder(orderDTO);
                orderRepository.save(order);
                return orderDTO;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public void delete(OrderDTO orderDTO) {
        if(orderDTO != null){
            if(orderRepository.existsById(orderDTO.getId())){
                orderRepository.deleteById(orderDTO.getId());
            }
        }
    }
}
