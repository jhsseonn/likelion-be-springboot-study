package com.example.bespringbootshop.repository;

import com.example.bespringbootshop.entity.Item;
import com.example.bespringbootshop.entity.ItemSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
