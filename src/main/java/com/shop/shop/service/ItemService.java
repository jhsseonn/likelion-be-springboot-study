package com.shop.shop.service;

import com.shop.shop.dto.ItemFormDto;
import com.shop.shop.dto.ItemSearchDto;
import com.shop.shop.dto.MainItemDto;
import com.shop.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception;

    Long updateItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception;

    ItemFormDto getItemDtl(Long itemId);

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}
