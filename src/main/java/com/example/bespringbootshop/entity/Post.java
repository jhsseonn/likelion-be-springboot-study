package com.example.bespringbootshop.entity;

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
    private Long id;

    @Column(nullable = false)
    private String postWriter;

    @Column(nullable = false, length=50)
    private String postTitle;

    @Lob
    @Column(nullable = false)
    private String postContent;

    @Column(name="postView", nullable = false)
    private int postView;

    private int postWishes;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
