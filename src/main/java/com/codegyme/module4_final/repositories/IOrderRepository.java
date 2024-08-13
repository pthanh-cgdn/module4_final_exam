package com.codegyme.module4_final.repositories;

import com.codegyme.module4_final.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Query(nativeQuery = true, value = "select * from orders as s where date between :startDate and :endDate order by date desc")
    Page<Order> findAllByDate(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate, Pageable pageable);

    @Query(nativeQuery = true, value = "select s.*, (s.quantity*p.price) as amount from orders as s join products as p on s.product_id = p.id group by s.id order by amount desc")
    List<Order> findTopOrderByAmount(@Param("top") Integer top);
}
