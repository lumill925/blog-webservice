package com.sparta.blogwebservice.service;

import com.sparta.blogwebservice.domain.Users;
import com.sparta.blogwebservice.repository.UsersRepository;
import com.sparta.blogwebservice.domain.UsersRoleEnum;
import com.sparta.blogwebservice.dto.Users.SignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final PasswordEncoder passwordEncoder;

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        Optional<Users> found = usersRepository.findByUsername(username);
        if(found.isPresent()) {
            throw new IllegalStateException("중복된 사용자 이름이 존재합니다ㅣ.");
        }

        String password = passwordEncoder.encode(requestDto.getPassword());

        UsersRoleEnum role = UsersRoleEnum.USER;

        Users users = new Users(username, password, role);
        usersRepository.save(users);


    }


}
