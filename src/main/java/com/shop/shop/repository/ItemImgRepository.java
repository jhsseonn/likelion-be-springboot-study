package com.shop.shop.repository;

import com.shop.shop.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {


    // 테스트코드

    List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);
}
