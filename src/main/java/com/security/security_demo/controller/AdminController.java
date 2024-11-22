package com.security.security_demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/message")
    public String getMessage() {
        return "admin controller";
    }

    @GetMapping("/public")
    public String publicMethod() {
        return "Hello user";
    }
}
