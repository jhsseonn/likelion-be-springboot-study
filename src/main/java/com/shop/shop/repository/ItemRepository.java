package com.shop.shop.repository;

import com.shop.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>, ItemRepositoryCustom {

    List<Item> findByItemNm(String itemNm); // 검색

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail); //OR 조건 처리

    List<Item> findByPriceLessThan(Integer price); //LessThan 조건 처리하기

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price); //OrderBy로 정렬 처리하기

    //@Query 어노테이션으로 복잡한 쿼리 처리하기
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    //@Query-nativeQuery 속성 예제
    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}
