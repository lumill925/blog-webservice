package com.sparta.blogwebservice.security;

import com.sparta.blogwebservice.domain.Users;
import com.sparta.blogwebservice.domain.UsersRoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private final Users users;

    public UserDetailsImpl(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_USER");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(adminAuthority);

        return authorities;
    }
}
