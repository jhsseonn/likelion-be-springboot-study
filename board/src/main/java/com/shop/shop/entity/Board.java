package com.shop.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="board")
@Getter
@Setter
@ToString
public class Board {

    @Id
    @Column(name="board_num")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardNm;//게시글 번호

    @Column(nullable = false)
    private String boardTitle; //게시글 제목


    @Column(nullable = false)
    private String boardDetail; //게시글 내용

    private LocalDateTime regTime;

}
