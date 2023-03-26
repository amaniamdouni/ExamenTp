package com.example.demo.Controller;


import com.example.demo.Entitys.User;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService ;
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user)
    {
        userService.addUser(user);
    }
}
