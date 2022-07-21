package com.example.delivery1.delivery.repository;

import com.sparta.delivery.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
