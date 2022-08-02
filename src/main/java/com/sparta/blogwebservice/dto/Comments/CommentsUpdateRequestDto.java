package com.sparta.blogwebservice.dto.Comments;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentsUpdateRequestDto {

    private String comment;

    @Builder
    public CommentsUpdateRequestDto(String comment) {
        this.comment = comment;
    }
}
