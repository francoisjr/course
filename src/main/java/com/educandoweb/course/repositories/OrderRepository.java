package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.OrderEntity;
import com.educandoweb.course.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
