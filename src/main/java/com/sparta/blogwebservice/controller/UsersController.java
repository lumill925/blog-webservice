package com.sparta.blogwebservice.controller;

import com.sparta.blogwebservice.dto.Users.SignupRequestDto;
import com.sparta.blogwebservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/api/member/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signupapi/member/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        usersService.registerUser(requestDto);
        return "redirect:/api/member/login";
    }
}
