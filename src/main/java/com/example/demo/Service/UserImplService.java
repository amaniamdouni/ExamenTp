package com.example.demo.Service;

import com.example.demo.Entitys.Project;
import com.example.demo.Entitys.User;
import com.example.demo.Repository.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImplService implements UserService{
    @Autowired
    private UserRepositroy userRepositroy;


    @Override
    public void addUser(User user) {
        userRepositroy.save(user);
    }
}
