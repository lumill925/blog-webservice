package com.sparta.blogwebservice.dto.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
}
