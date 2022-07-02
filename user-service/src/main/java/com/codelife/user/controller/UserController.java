package com.codelife.user.controller;

import com.codelife.user.VO.ResponseTemplateOV;
import com.codelife.user.entity.User;
import com.codelife.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside Save User Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateOV getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside get User Controller");
        return userService.getUserWithId(userId);
    }
}
