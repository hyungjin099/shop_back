package com.green.book_shop.test;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
  private final UploadUtil uploadUtil;

  @GetMapping("/1")
  public int test1(){
    return 5;
  }

  //첨부파일을 자바에서 받기위해서 FormData 객체를 사용했다.
  //전달되는 데이터의 형태도 multipart/form-data 형식으로 변환해서 전달.
  //이렇게 전달되는 데이터를 받기 위한 코드를 변경했기 때문에
  //평소랑 다르게 데이터를 전달받아야 함
  //DTO객체로 전달된 데이터를 받되, @RequestBody 어노테이션은 사용하지 않는다.
  //그렇다고 해서 DTO 객체로 첨부파일 정보도 받는 것은 아니다.
  //첨부파일 데이터를 받을 때는 MultiPartFile 객체를 사용한다.
  //첨부파일 연습1
  @PostMapping("/upload1")
  public void upload1(BookDTO bookDTO,
                      @RequestParam(name = "firstFile", required = false) MultipartFile file){
    //단일 첨부 파일 업로드
    uploadUtil.fileUpload(file);

  }

  //첨부할 파일에 여러개 들어오면 MultipartFile[] 형태로 데이터를 받음
  @PostMapping("/upload2")
  public void upload2(@RequestParam(name = "files", required = false) MultipartFile[] files){
    //다중 파일 업로드
    uploadUtil.multiFileUpload(files);
  }

}










