package com.example.bespringbootshop.repository;

import com.example.bespringbootshop.entity.Item;
import com.example.bespringbootshop.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByPostTitle(String postTitle);
    List<Post> findByPostTitleOrPostContent(String postTitle, String postContent);
    List<Post> findByPostViewLessThan(Integer postView);
    List<Post> findByPostViewLessThanOrderByPostViewDesc(Integer postView);
    @Query("select i from Post i where i.postContent like %:postContent% order by i.postView desc")
    List<Post> findByPostContent(@Param("postContent") String postContent);
}
