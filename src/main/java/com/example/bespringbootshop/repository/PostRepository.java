package com.example.bespringbootshop.repository;

import com.example.bespringbootshop.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository {
    List<Post> findByPostTitle(String title);
    List<Post> findByPostTitleOrContent(String title, String content);
    List<Post> findByCheckLessThan(Integer check);
    List<Post> findByCheckLessThenOrderByDesc(Integer check);

    @Query("select i from Post i where i.content like %:content% order by i.check desc")
    List<Post> findByPostContent(@Param("content") String content);
}
