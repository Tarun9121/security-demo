package com.security.security_demo.controller;

import com.security.security_demo.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
//@SecurityRequirement
public class UserController {
    @GetMapping("/message")
    public String getMessage() {
        return "user controller";
    }

    @GetMapping("/public")
    public String publicMethod() {
        return "Hello user";
    }

    @PostMapping("/data")
    public UserDto getData(@RequestBody UserDto userDto) {
        return userDto;
    }
}