package com.shop.shop.service;

import com.shop.shop.entity.ItemImg;
import org.springframework.web.multipart.MultipartFile;

public interface ItemImgService {

    void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws Exception;

    void updateItemImg(Long itemImgId, MultipartFile itemImgFile) throws Exception;

}
