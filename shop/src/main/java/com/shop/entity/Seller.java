package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "seller")
@Getter
@Setter
@ToString
public class Seller {

    // 판매자 번호
    @Id
    @Column(name = "seller_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 판매자명
    @Column(nullable = false, length = 50)
    private String sellerName;

    // 판매 품목 개수
    @Column(nullable = false)
    private int sellingItemNum;

    // 판매자 평점
    @Column
    private double sellerGrade;
}
