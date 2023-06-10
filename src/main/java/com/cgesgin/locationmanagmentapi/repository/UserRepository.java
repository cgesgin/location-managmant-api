package com.cgesgin.locationmanagmentapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgesgin.locationmanagmentapi.core.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByEmailAndPassword(String email, String password);
    public User findByEmail(String email);
}
