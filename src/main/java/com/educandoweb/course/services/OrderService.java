package com.educandoweb.course.services;

import com.educandoweb.course.entities.OrderEntity;
import com.educandoweb.course.entities.CategoryEntity;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<OrderEntity> findAll(){
        return  repository.findAll();
    }

    public OrderEntity findById(Long id){
        Optional<OrderEntity> obj = repository.findById(id);
        return obj.get();
    }
}
