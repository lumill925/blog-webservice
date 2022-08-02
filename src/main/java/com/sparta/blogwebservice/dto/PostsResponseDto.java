package com.sparta.blogwebservice.dto;

import com.sparta.blogwebservice.domain.Posts;

public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
