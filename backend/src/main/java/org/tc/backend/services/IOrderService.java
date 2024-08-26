package org.tc.backend.services;

import org.springframework.data.domain.Page;
import org.tc.backend.dtos.OrderDTO;
import org.tc.backend.exceptions.DataNotFoundException;
import org.tc.backend.models.Order;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    Order createOrder(OrderDTO orderDTO) throws Exception;
    Order getOrder(Long id);
    Order updateOrder(Long id, OrderDTO orderDTO) throws DataNotFoundException;
    void deleteOrder(Long id);
    List<Order> findByUserId(Long userId);
    Page<Order> getOrdersByKeyword(String keyword, Pageable pageable);
}
