package com.sparta.blogwebservice.security;

import com.sparta.blogwebservice.domain.Users;
import com.sparta.blogwebservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(username + "을 찾을 수 없습니다.")
                );

        return new UserDetailsImpl(users);
    }
}
