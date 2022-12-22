package com.example.userservice.controller;

import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {

    private UserService userService;

    @PostMapping
    public User saveUser(
            @RequestBody User user) {
        log.info("inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserAndDepartment(
            @PathVariable("id") Long userId
    ){
        log.info("inside getUserAndDepartment of UserController");
        return userService.getUserAndDepartmentById(userId);
    }
}
