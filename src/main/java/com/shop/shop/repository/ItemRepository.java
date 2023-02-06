package com.shop.shop.repository;

import com.shop.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNm(String itemNm); // 검색

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail); //OR 조건 처리

    List<Item> findByPriceLessThan(Integer price); //LessThan 조건 처리하기

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price); //OrderBy로 정렬 처리하기
}
