package com.shop.shop.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.shop.entity.Post;
import com.shop.shop.entity.QPost;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class PostRepositoryTest {

    @PersistenceContext
    EntityManager em; // 영속성 컨텍스트를 사용하기 위해 @PersistenceContext 어노테이션을 이용해 EntityManager 빈을 주임


    @Autowired
    PostRepository postRepository;

    // 테스트 게시글 저장
    public void createPostList(){
        for(int i=1; i<=10; i++){
            Post post = new Post();
            post.setWriter("작성자" + i);
            post.setTitle("제목" + i);
            post.setContent("내용" + i);
            post.setRegTime(LocalDateTime.now());
            post.setUpdateTime(LocalDateTime.now());

            Post savedPost = postRepository.save(post);
            System.out.println(savedPost.toString());
        }
    }

    @Test
    @DisplayName("작성자 조회 테스트")
    public void findByWriterTest(){
        this.createPostList();
        List<Post> postList = postRepository.findByWriter("작성자1");
        for(Post post : postList){
            System.out.println(post.toString());
        }
    }

    @Test
    @DisplayName("제목, 내용 or 테스트")
    public void findByTitleOrContentTest(){
        this.createPostList();
        List<Post> postList = postRepository.findByTitleOrContent("작성자1", "내용2");
        for(Post post : postList){
            System.out.println(post.toString());
        }
    }

    @Test
    @DisplayName("@Query를 이용한 게시글 제목 검색 테스트")
    public void findByTitleTest(){
        this.createPostList();
        List<Post> postList = postRepository.findByTitle("제목");
        for(Post post : postList){
            System.out.println(post.toString());
        }
    }

    @Test
    @DisplayName("Querydsl 조회 테스트1")
    // 제목 또는 내용에 키워드가 들어가는 게시글 조회
    public void queryDslTest(){
        this.createPostList();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QPost qPost = QPost.post;
        JPAQuery<Post> query = queryFactory.selectFrom(qPost)
                .where(qPost.title.like("%" + "제목" + "%").or(qPost.content.like("%" + "테스트 상품 상세 설명" + "%")))
                .orderBy(qPost.regTime.desc());

        List<Post> postList = query.fetch(); // 쿼리 결과를 리스트로 반환

        for(Post post : postList){
            System.out.println(post.toString());
        }
    }

    // 특정 작성자글 중 제목, 내용으로 키워드가 들어가는 게시글 조회
    @Test
    @DisplayName("Querydsl 조회 테스트2")
    public void queryDslTest2(){

        this.createPostList();

        BooleanBuilder builder = new BooleanBuilder();
        QPost post = QPost.post;

        String writer = "작성자1";
        String title = "제목";
        String content = "내용";

        builder.and(post.writer.eq(writer));
        builder.and(post.title.like("%" + title + "%").or(post.content.like("%" + content + "%")));

        Pageable pageable = PageRequest.of(0, 5);
        Page<Post> postPageResult =
                postRepository.findAll(builder, pageable);
        System.out.println("total elements : " + postPageResult. getTotalElements ());

        List<Post> resultPostList = postPageResult.getContent();
//        Iterable<Post> postList = postRepository.findAll(builder);
        for(Post resultPost: resultPostList){
            System.out.println(resultPost.toString());
        }

    }

}