package com.shop.shop.repository;

import com.shop.shop.dto.ItemSearchDto;
import com.shop.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    // 상품 조회 조건과 페이징 정보를 담는 객체들을 파라미터로 받는 메소드
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
