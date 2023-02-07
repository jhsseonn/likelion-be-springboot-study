package com.shop.shop.repository;

import com.shop.shop.entity.Item;
import com.shop.shop.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, QuerydslPredicateExecutor<Post> {

    List<Post> findByWriter(String writer); // 작성자명으로 게시글 검색

    List<Post> findByTitleOrContent(String title, String content); // 제목, 내용으로 OR 조건 처리

    // 제목에 키워드를 검색하면 최신순 정렬
    @Query("select p from Post p where p.title like %:title% order by p.regTime desc")
    List<Post> findByTitle(@Param("title") String title);

}
