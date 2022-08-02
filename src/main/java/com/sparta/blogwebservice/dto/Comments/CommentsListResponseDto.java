package com.sparta.blogwebservice.dto.Comments;

import com.sparta.blogwebservice.domain.Comments;
import com.sparta.blogwebservice.domain.Posts;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


public class CommentsListResponseDto {
    private Long id;
    private Posts posts;
    private String comment;
    private String author;
    private LocalDateTime modifiedDate;

    public CommentsListResponseDto(Comments entity) {
        this.id = entity.getId();
        this.posts = entity.getPosts();
        this.comment = entity.getComment();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }

}
