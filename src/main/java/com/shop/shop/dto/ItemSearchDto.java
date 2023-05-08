package com.shop.shop.dto;

import com.shop.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchDto {

    private String searchDateType; //현재 시간과 상품 등록일을 비교해 상품 데이터를 조회

    private ItemSellStatus searchSellStatus; // 판매 상태를 기준으로 데이터를 조회

    private String searchBy; //상품 조회 유형

    private String searchQuery = ""; // 조회할 검색어를 저장할 변수
}
