package com.sparta.blogwebservice.controller;

import com.sparta.blogwebservice.domain.Comments;
import com.sparta.blogwebservice.domain.Posts;
import com.sparta.blogwebservice.domain.PostsRepository;
import com.sparta.blogwebservice.dto.Posts.PostsResponseDto;
import com.sparta.blogwebservice.dto.Posts.PostsSaveRequestDto;
import com.sparta.blogwebservice.dto.Posts.PostsUpdateRequestDto;
import com.sparta.blogwebservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/posts")
@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;
    private final PostsRepository postsRepository;

    @PostMapping
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @GetMapping
    public List<Posts> get(){
        return postsRepository.findAllByOrderByModifiedDateDesc();
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
