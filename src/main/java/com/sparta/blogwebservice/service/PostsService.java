package com.sparta.blogwebservice.service;

import com.sparta.blogwebservice.domain.Posts;
import com.sparta.blogwebservice.domain.PostsRepository;
import com.sparta.blogwebservice.dto.PostsListResponseDto;
import com.sparta.blogwebservice.dto.PostsResponseDto;
import com.sparta.blogwebservice.dto.PostsSaveRequestDto;
import com.sparta.blogwebservice.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity())
                .getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 포스트가 없습니다. id=" + id)
                );
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)
                );
        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 포스트가 없습니다. id=" + id)
                );
        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
