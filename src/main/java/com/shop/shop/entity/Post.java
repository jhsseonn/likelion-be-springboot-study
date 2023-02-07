package com.shop.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 게시글 id

    private String writer;// 작성자

    @Column(length = 40, nullable = false)
    private String title; // 제목

    @Lob
    @Column(nullable = false)
    private String content;// 내용

    private LocalDateTime regTime; // 등록시강

    private LocalDateTime updateTime; // 수정시간
}
