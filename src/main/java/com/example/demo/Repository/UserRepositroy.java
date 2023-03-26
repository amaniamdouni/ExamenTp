package com.example.demo.Repository;

import com.example.demo.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositroy extends JpaRepository<User,Integer> {
    User findByNomPrenom(String firstname,String lastname);
}
