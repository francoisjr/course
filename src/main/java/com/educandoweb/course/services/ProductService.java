package com.educandoweb.course.services;

import com.educandoweb.course.entities.ProductEntity;
import com.educandoweb.course.entities.UserEntity;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductEntity> findAll(){
        return  repository.findAll();
    }

    public ProductEntity findById(Long id){
        Optional<ProductEntity> obj = repository.findById(id);
        return obj.get();
    }
}
