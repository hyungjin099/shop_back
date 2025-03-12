package com.green.book_shop.book.mapper;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
  //카테고리 목록 조회
  public List<BookCategoryDTO> selectCategoryList();

  //도서 등록
  public void insertBook(BookDTO bookDTO);

  //카테고리명 중복 확인 쿼리
  public String isUsableCateName(String cateName);

  //카테고리 등록 쿼리
  public int insertCategory(String cateName);


}
