package com.sparta.blogwebservice.repository;

import com.sparta.blogwebservice.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findAllByOrderByModifiedDateDesc();
//    @Query("select p from Posts p order by p.id desc")
//    List<Posts> findAllDesc();
}
