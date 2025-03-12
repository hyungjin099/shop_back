package com.green.book_shop.user.service;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
  private final UserMapper userMapper;

  //회원가입
  @Override
  public boolean join(UserDTO userDTO) {
    //회원가입 여부 변수
    boolean isJoin = false;

    //아이디가 중복이다 -> 조회된 데이터가 null이 아니다
    //아이디가 중복이 아니다 -> 조회된 데이터는 null이다
    String selectedUserId = userMapper.checkUserId(userDTO.getUserId());

    //아이디가 중복이 아닐 때만 회원가입 실행
    if(selectedUserId == null){
      userMapper.join(userDTO);
      isJoin = true;
    }
    return isJoin;
  }

  //로그인
  @Override
  public UserDTO login(UserDTO userDTO) {
    return userMapper.login(userDTO);
  }
}
