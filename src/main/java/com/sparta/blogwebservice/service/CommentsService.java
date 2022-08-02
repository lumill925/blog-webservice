package com.sparta.blogwebservice.service;

import com.sparta.blogwebservice.domain.Comments;
import com.sparta.blogwebservice.domain.CommentsRepository;
import com.sparta.blogwebservice.dto.Comments.CommentsListResponseDto;
import com.sparta.blogwebservice.dto.Comments.CommentsResponseDto;
import com.sparta.blogwebservice.dto.Comments.CommentsSaveResquestDto;
import com.sparta.blogwebservice.dto.Comments.CommentsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    @Transactional
    public Long save(CommentsSaveResquestDto resquestDto) {
        return commentsRepository.save(resquestDto.toEntity())
                .getId();
    }

    @Transactional
    public Long update(Long id, CommentsUpdateRequestDto requestDto) {
        Comments comments = commentsRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 코멘트가 없습니다. id=" + id)
                );
        comments.update(requestDto.getComment());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Comments comments = commentsRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 코멘트가 없습니다. id=" + id)
                );
        commentsRepository.delete(comments);
    }

    public CommentsResponseDto findById(Long id) {
        Comments comments = commentsRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 코멘트가 없습니다. id=" + id)
                );
        return new CommentsResponseDto(comments);
    }

//    @Transactional
//    public List<CommentsListResponseDto> findAllDesc() {
//        List<CommentsListResponseDto> collect = commentsRepository.findAllDesc().stream()
//                .map(CommentsListResponseDto::new)
//                .collect(Collectors.toList());
//        return collect;
//    }
}
