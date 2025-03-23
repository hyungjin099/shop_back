package com.green.book_shop.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

//첨부파일 기능 모음 클래스
@Component
public class UploadUtil {
  //application.properties 파일에 정의한
  //file.upload.dir 값을 가져와서 uploadPath 변수에 저장
  @Value("${file.upload.dir}")
  private String uploadPath;

  //단일 파일 업로드
  public void fileUpload(MultipartFile file){
    //파일을 첨부하지 않았으면...
    if(file == null){
      return;
    }

    //화면에서 선택한 원본 파일명
    String originFileName = file.getOriginalFilename();

    //첨부할 파일명
    String attachFileName = getAttachedFileName(originFileName);

    //업로드 경로 , 파일명을 연결 -> ex> D://devel/abc.jpg
    File f = new File(uploadPath + attachFileName);

    try {
      //파일 첨부
      //첨부한 파일(file)을 실제 업로드할 경로(f)로 옮긴다.
      file.transferTo(f);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  //다중 파일 업로드
  public void multiFileUpload(MultipartFile[] files){
    for(MultipartFile eachFile : files){
      fileUpload(eachFile);
    }
  }

  //원본파일명에서 첨부할 파일명을 생성하는 메서드
  public String getAttachedFileName(String originFileName){
    //첨부할 파일명(랜덤한 문자열 생성)
    String uuid = UUID.randomUUID().toString();
    System.out.println(originFileName);

    //화면에서 선택한 파일의 확장자 추출
    String[] result = originFileName.split("\\.");
    System.out.println(Arrays.toString(result));
    String extension = result[result.length - 1];

    //완성된 첨부할 파일명
    //abc.jpg
    //fsdfsd-fdfwefews-fdsfsd.jpg
    String attachFileName = uuid + "." + extension;
    return attachFileName;
  }

}




