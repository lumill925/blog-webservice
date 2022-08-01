package com.sparta.blogwebservice.domain;

import com.sparta.blogwebservice.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {}
