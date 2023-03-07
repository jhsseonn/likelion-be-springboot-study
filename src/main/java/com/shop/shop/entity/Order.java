package com.shop.shop.entity;

import com.shop.shop.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    // 한 명의 회원은 여러 번 주문할 수 있으므로 주문 엔티티 기준에서 다대일 단방향 매핑을 한다
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate;  // 주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;  // 주문 상태

    // 주문 상품 엔티티와 일대다 매핑
    // 외래키(order_id)가 order_item 테이블에 있으므로 연관 관계의 주인은 OrderItem 엔티티
    // Order 엔티티가 주인이 아니므로 "mappedBy" 속성으로 연관 관계의 주인을 설정
    // 속성 값으로 order를 적은 이유는 OrderItem에 있는 Order에 의해 관리된다는 의미로 해석
    // 즉, 연관 관계의 주인의 필드인 order를 mappedBy의 값으로 세팅하면 된다
    @OneToMany(mappedBy = "order")
    // 하나의 주문이 여러 개의 주문 상품을 갖으므로 List 자료형을 사용해서 mapping
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
