package com.sparta.blogwebservice.controller;

import com.sparta.blogwebservice.domain.Comments;
import com.sparta.blogwebservice.repository.CommentsRepository;
import com.sparta.blogwebservice.domain.UsersRoleEnum;
import com.sparta.blogwebservice.dto.Comments.CommentsResponseDto;
import com.sparta.blogwebservice.dto.Comments.CommentsSaveResquestDto;
import com.sparta.blogwebservice.dto.Comments.CommentsUpdateRequestDto;
import com.sparta.blogwebservice.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/comment")
@RequiredArgsConstructor
@RestController
public class CommentsController {

    private final CommentsService commentsService;
    private final CommentsRepository commentsRepository;

    @Secured(value = UsersRoleEnum.Authority.USER)
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

    @Secured(value = UsersRoleEnum.Authority.USER)
    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody CommentsUpdateRequestDto requestDto) {
        return commentsService.update(id, requestDto);
    }

    @Secured(value = UsersRoleEnum.Authority.USER)
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        commentsService.delete(id);
        return id;
    }
}
