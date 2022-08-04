package com.sparta.blogwebservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .ignoringAntMatchers("/user/**");
        http
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/css/**").permitAll()
                        .antMatchers("/user/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin()
                .loginPage("/api/member/login")
                .loginProcessingUrl("/api/member/login")
                .defaultSuccessUrl("/")
                .failureUrl("/api/member/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/forbidden.html");


        return http.build();
    }
}