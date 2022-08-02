package com.sparta.blogwebservice.dto.Comments;

import com.sparta.blogwebservice.domain.Comments;
import com.sparta.blogwebservice.domain.Posts;
import lombok.Getter;

@Getter
public class CommentsResponseDto {

    private Long id;
    private Posts posts;
    private String comment;
    private String author;

    public CommentsResponseDto(Comments entity) {
        this.id = entity.getId();
        this.posts = entity.getPosts();
        this.comment = entity.getComment();
        this.author = entity.getAuthor();
    }
}
