/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.config;

import com.cim.typeA.service.impl.AuthenticationProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 *
 * @author USER
 */

@RequiredArgsConstructor
@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter{

final AuthenticationProviderService authenticationProvider;

    @Bean
public BCryptPasswordEncoder bCryptPasswordEncoder(){
return new BCryptPasswordEncoder();
}

@Bean
public SCryptPasswordEncoder sCryptPasswordEncoder(){
return new SCryptPasswordEncoder();
}

@Override
protected void configure(AuthenticationManagerBuilder auth){
auth.authenticationProvider(authenticationProvider);
}

@Override
public void configure(HttpSecurity http) throws Exception{
http.formLogin().defaultSuccessUrl("/login", true);
http.authorizeRequests().anyRequest().authenticated();
}
}
