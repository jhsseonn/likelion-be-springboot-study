package com.shop.shop.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {

    String uploadFile(String uploadPath, String originalFileName, byte[] fileDate) throws IOException;

    void deleteFile(String filePath) throws Exception;

}
