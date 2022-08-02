package com.sparta.blogwebservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    List<Comments> findAllByOrderByModifiedDateDesc();
//    @Query("select c from Comments c order by c.id desc")
//    List<Posts> findAllDesc();
}
