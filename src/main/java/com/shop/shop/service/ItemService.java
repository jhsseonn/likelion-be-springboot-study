package com.shop.shop.service;

import com.shop.shop.dto.ItemFormDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception;

    //Long updateItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception;
}
