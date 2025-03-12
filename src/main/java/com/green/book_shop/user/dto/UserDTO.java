package com.green.book_shop.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class UserDTO {
  private String userId;
  private String userPw;
  private String userName;
  private String userEmail;
  private String userTel;
  private String userRoll;
  private String isUsing;
  LocalDateTime joinDate;
}
