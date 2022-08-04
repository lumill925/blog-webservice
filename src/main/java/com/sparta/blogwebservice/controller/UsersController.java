package com.sparta.blogwebservice.controller;

import com.sparta.blogwebservice.dto.Users.SignupRequestDto;
import com.sparta.blogwebservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/signup")
    public String registerUser(SignupRequestDto requestDto) {
        usersService.registerUser(requestDto);
        return "redirect:/api/member/login";
    }
}
