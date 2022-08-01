package com.sparta.blogwebservice.controller;

import com.sparta.blogwebservice.dto.PostsResponseDto;
import com.sparta.blogwebservice.dto.PostsSaveRequestDto;
import com.sparta.blogwebservice.dto.PostsUpdateRequestDto;
import com.sparta.blogwebservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;

    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
