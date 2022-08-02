package com.sparta.blogwebservice.controller;

import com.sparta.blogwebservice.domain.CommentsRepository;
import com.sparta.blogwebservice.domain.PostsRepository;
import com.sparta.blogwebservice.service.CommentsService;
import com.sparta.blogwebservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final CommentsService commentsService;
    private final PostsRepository postsRepository;
    private final CommentsRepository commentsRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsRepository.findAllByOrderByModifiedDateDesc());

        return "views/index";

    }
}
