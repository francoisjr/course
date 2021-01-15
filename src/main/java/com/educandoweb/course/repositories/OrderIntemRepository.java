package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.OrderItemEntity;
import com.educandoweb.course.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderIntemRepository extends JpaRepository<OrderItemEntity, Long> {
}
