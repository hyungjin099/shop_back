package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;

public interface UserService {
  //회원 가입
  public boolean join(UserDTO userDTO);

  //로그인
  public UserDTO login(UserDTO userDTO);
}
