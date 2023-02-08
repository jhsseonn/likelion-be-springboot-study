package com.example.bespringbootshop.repository;

import com.example.bespringbootshop.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @DisplayName("게시글 저장 테스트")
    public void createPostTest(){
        for (int i=1;i<=5;i++){
            Post post=new Post();
            post.setPostTitle("상품 게시글"+i);
            post.setPostContent("상품 게시글 상세 설명"+i);
            post.setPostView(100+i);
            post.setPostWishes(10+i);
            post.setPostWriter("작성자"+i);
            post.setRegTime(LocalDateTime.now());
            Post savedPost=postRepository.save(post);
//        System.out.println(savedItem.toString());
        }
    }

    @Test
    void findByPostTitle() {
    }

    @Test
    void findByPostTitleOrContent() {
    }

    @Test
    void findByCheckLessThan() {
    }

    @Test
    void findByCheckLessThenOrderByDesc() {
    }

    @Test
    void findByPostContent() {
    }
}