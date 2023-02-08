package com.example.bespringbootshop.repository;

import com.example.bespringbootshop.entity.Item;
import com.example.bespringbootshop.entity.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

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
    @DisplayName("게시글 제목 검색 테스트")
    void findByPostTitle() {
        this.createPostTest();
        List<Post> postList = postRepository.findByPostTitle("상품 게시글2");
        for(Post post:postList){
            System.out.println(post.toString());
        }
    }

    @Test
    @DisplayName("게시글 제목+내용으로 검색 테스트")
    void findByPostTitleOrPostContent() {
        this.createPostTest();
        List<Post> postList = postRepository.findByPostTitleOrPostContent("상품 게시글1", "상품 게시글 상세 설명1");
        for(Post post:postList){
            System.out.println(post.toString());
        }
    }

    @Test
    @DisplayName("조회수 Less Than 테스트")
    void findByPostViewLessThan() {
        this.createPostTest();
        List<Post> postList=postRepository.findByPostViewLessThan(103);
        for(Post post:postList){
            System.out.println(post.toString());
        }
    }

    @Test
    void findByPostViewLessThenOrderByDesc() {
    }

    @Test
    void findByPostContent() {
    }
}