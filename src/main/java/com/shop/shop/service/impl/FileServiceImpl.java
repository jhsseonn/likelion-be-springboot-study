package com.shop.shop.service.impl;

import com.shop.shop.service.FileService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Log
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws IOException {
        UUID uuid = UUID.randomUUID();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        // UUID로 받은 값과 원해 파일의 이름의 확장자를 조합해 저장될 파일 이름 생성
        String savedFileName = uuid.toString() + extension;
        String fileUploadFullUrl = uploadPath + "/" + savedFileName;
        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
        fos.write(fileData); // 파일 출력 스트림에 입력
        fos.close();

        return savedFileName; // 업로드된 파일의 이름을 반환
    }

    @Override
    public void deleteFile(String filePath) throws Exception {
        File deleteFile = new File(filePath); // 파일이 저장된 경로를 이용해 파일 객체를 생성

        // 해당 파일이 존재하면 파일을 삭제
        if(deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일을 삭제하였습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }
}
