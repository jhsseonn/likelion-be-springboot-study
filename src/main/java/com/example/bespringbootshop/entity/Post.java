package com.example.bespringbootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table("post")
@Getter
@Setter
@ToString
public class Post {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private int check;
    private int wish;
    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
