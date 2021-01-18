package com.educandoweb.course.services;

import com.educandoweb.course.entities.UserEntity;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserEntity> findAll(){
        return  repository.findAll();
    }

    public UserEntity findById(Long id){
        Optional<UserEntity> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UserEntity insert(UserEntity obj){
         return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserEntity update(Long id, UserEntity obj){
        try{
            UserEntity userEntity = repository.getOne(id);
            updateData(userEntity, obj);
            return repository.save(userEntity);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(UserEntity userEntity, UserEntity obj){
        userEntity.setName(obj.getName());
        userEntity.setEmail(obj.getEmail());
        userEntity.setPhone(obj.getPhone());
    }

}
