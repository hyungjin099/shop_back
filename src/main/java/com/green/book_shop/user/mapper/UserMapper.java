package com.green.book_shop.user.mapper;

import com.green.book_shop.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  //회원 가입
  public void join(UserDTO userDTO);

  //id 중복 확인
  public String checkUserId(String userId);

  //로그인
  public UserDTO login(UserDTO userDTO);

}




