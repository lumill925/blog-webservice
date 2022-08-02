package com.sparta.blogwebservice.controller;

import com.sparta.blogwebservice.domain.Comments;
import com.sparta.blogwebservice.domain.CommentsRepository;
import com.sparta.blogwebservice.dto.Comments.CommentsResponseDto;
import com.sparta.blogwebservice.dto.Comments.CommentsSaveResquestDto;
import com.sparta.blogwebservice.dto.Comments.CommentsUpdateRequestDto;
import com.sparta.blogwebservice.dto.Posts.PostsResponseDto;
import com.sparta.blogwebservice.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/comment")
@RequiredArgsConstructor
@RestController
public class CommentsController {

    private final CommentsService commentsService;
    private final CommentsRepository commentsRepository;

    @PostMapping
    public Long save(@RequestBody CommentsSaveResquestDto requestDto) {
        return commentsService.save(requestDto);
    }

    @GetMapping
    public List<Comments> get() {
        return commentsRepository.findAllByOrderByModifiedDateDesc();
    }

    @GetMapping("/{id}")
    public CommentsResponseDto findById (@PathVariable Long id) {
        return commentsService.findById(id);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody CommentsUpdateRequestDto requestDto) {
        return commentsService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        commentsService.delete(id);
        return id;
    }
}
