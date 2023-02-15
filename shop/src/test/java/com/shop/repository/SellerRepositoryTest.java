package com.shop.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.ShopApplication;
import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import com.shop.entity.QItem;
import com.shop.entity.QSeller;
import com.shop.entity.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(classes = ShopApplication.class)
@TestPropertySource(locations="classpath:application-test.properties")
class SellerRepositoryTest {

    @Autowired
    SellerRepository sellerRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("판매자 저장 테스트")
    public void createSellerTest(){
        Seller seller = new Seller();
        seller.setSellerName("테스트 판매자");
        seller.setSellingItemNum(10);
        seller.setSellerGrade(0.5);
        Seller savedSeller = sellerRepository.save(seller);
        System.out.println(savedSeller.toString());
    }

    public void createSellerList() {
        for(int i=1;i<=10;i++){
            Seller seller = new Seller();
            seller.setSellerName("테스트 판매자 " + i);
            seller.setSellingItemNum(10 * i);
            seller.setSellerGrade(0.5 + i);
            Seller savedSeller = sellerRepository.save(seller);
        }
    }


    @Test
    @DisplayName("판매자명 조회 테스트")
    void findBySellerName() {
        this.createSellerList();
        List<Seller> sellerList = sellerRepository.findBySellerName("테스트 판매자 1");
        for(Seller seller : sellerList) {
            System.out.println(seller.toString());
        }
    }


    @Test
    @DisplayName("판매자명, 판매 품목 개수 or 테스트")
    void findBySellerNameOrSellingItemNum() {
        this.createSellerList();
        List<Seller> sellerList = sellerRepository.findBySellerNameOrSellingItemNum("테스트 판매자 1", 30);
        for(Seller seller : sellerList) {
            System.out.println(seller.toString());
        }
    }

    @Test
    @DisplayName("판매자 평점 LessThan 테스트")
    void findBySellerGradeLessThan() {
        this.createSellerList();
        List<Seller> sellerList = sellerRepository.findBySellerGradeLessThan(2.5);
        for(Seller seller : sellerList) {
            System.out.println(seller.toString());
        }
    }


    @Test
    @DisplayName("판매자 평점 내림차순 조회 테스트")
    void findBySellerGradeLessThanOrderBySellerGradeDesc() {
        this.createSellerList();
        List<Seller> sellerList = sellerRepository.findBySellerGradeLessThanOrderBySellerGradeDesc(3.5);
        for(Seller seller : sellerList) {
            System.out.println(seller.toString());
        }
    }


    @Test
    @DisplayName("@Query를 이용한 판매자 조회 테스트")
    void findBySellerNameByQuery() {
        this.createSellerList();
        List<Seller> sellerList = sellerRepository.findBySellerNameByQuery("테스트 판매자");
        for(Seller seller : sellerList) {
            System.out.println(seller.toString());
        }
    }

    @Test
    @DisplayName("nativeQuery 속성을 이용한 판매자 조회 테스트")
    void findBySellerNameByNative() {
        this.createSellerList();
        List<Seller> sellerList = sellerRepository.findBySellerNameByNative("테스트 판매자");
        for(Seller seller : sellerList) {
            System.out.println(seller.toString());
        }
    }


    @Test
    @DisplayName("Querydsl 조회 테스트1")
    public void queryDslTest(){
        this.createSellerList();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QSeller qSeller = QSeller.seller;
        JPAQuery<Seller> query = queryFactory.selectFrom(qSeller)
                .where(qSeller.sellerGrade.eq(5.5))
                .where(qSeller.sellerName.like("%" + "테스트 판매자" + "%"))
                .orderBy(qSeller.sellingItemNum.desc());
        List<Seller> sellerList = query.fetch();

        for(Seller seller : sellerList) {
            System.out.println(seller.toString());
        }
    }

    public void createSellerList2() {
        for(int i=1;i<=5;i++){
            Seller seller = new Seller();
            seller.setSellerName("테스트 판매자 " + i);
            seller.setSellingItemNum(10 * i);
            seller.setSellerGrade(0.5 + i);
            Seller savedSeller = sellerRepository.save(seller);
        }
        for(int i=6;i<=10;i++){
            Seller seller = new Seller();
            seller.setSellerName("테스트 판매자 " + i);
            seller.setSellingItemNum(10 * i);
            seller.setSellerGrade(0.5 + i);
            Seller savedSeller = sellerRepository.save(seller);
        }
    }

}