package com.shop.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue
    @Column(name = "cart_item")
    private Long id;

    // 하나의 장바구니, 여러 개의 상품
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // 장바구니에 담은 상품 정보를 알기 위해 상품 엔티티와 매핑
    // 하나의 상품은 여러 장바구니의 장바구니 상품으로 담길 수 있음
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    // 같은 상품을 몇 개 담을지 저장
    private int count;
}
