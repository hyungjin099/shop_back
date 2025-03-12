package com.green.book_shop.user.controller;

import com.green.book_shop.user.dto.UserDTO;
import com.green.book_shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  //회원가입
  //(post) ~/users
  @PostMapping("")
  public boolean join(@RequestBody UserDTO userDTO){
    return userService.join(userDTO);
  }

  //로그인
  //(get) ~/users/login
  //@PathVariable, @RequestParam으로 전달되는 데이터는
  //url이 노출됨 -> 아이디, 비번 유출 우려 심함
  @GetMapping("/login")
  public UserDTO login(UserDTO userDTO){
    //조회된 데이터가 있다 -> 로그인 가능 -> loginUser가 null이 아니다
    //조회된 데이터가 없으면 -> 로그인 불가능 -> loginUser가 null이다
    UserDTO loginUser = userService.login(userDTO);
    return loginUser;
  }

}
