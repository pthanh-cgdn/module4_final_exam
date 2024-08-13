package com.codegyme.module4_final.services;

import com.codegyme.module4_final.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    Page<Order> findAll(Pageable pageable);

    Page<Order> findAllByDate(LocalDate startDate, LocalDate endDate, Pageable pageable);

    List<Order> findTopOrderByAmount(Integer top);

    Order findById(Long id);

    void save(Order order);
}
