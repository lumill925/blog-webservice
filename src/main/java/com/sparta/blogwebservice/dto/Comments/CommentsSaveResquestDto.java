package com.sparta.blogwebservice.dto.Comments;

import com.sparta.blogwebservice.domain.Comments;
import com.sparta.blogwebservice.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsSaveResquestDto {

    private Posts posts;
    private String comment;
    private String author;

    @Builder
    public CommentsSaveResquestDto(Posts posts, String comment, String author) {
        this.posts = posts;
        this.comment = comment;
        this.author = author;
    }

    public Comments toEntity() {
        return Comments.builder()
                .posts(posts)
                .comment(comment)
                .author(author)
                .build();
    }
}
