package com.codegyme.module4_final.services.impl;

import com.codegyme.module4_final.models.Order;
import com.codegyme.module4_final.repositories.IOrderRepository;
import com.codegyme.module4_final.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;
    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Page<Order> findAllByDate(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return orderRepository.findAllByDate(startDate, endDate, pageable);
    }

    @Override
    public List<Order> findTopOrderByAmount(Integer top) {
        return orderRepository.findTopOrderByAmount(top);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
