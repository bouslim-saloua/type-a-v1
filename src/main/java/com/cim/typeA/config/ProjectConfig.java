/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 *
 * @author USER
 */

@Configuration
public class ProjectConfig {
    @Bean
public BCryptPasswordEncoder bCryptPasswordEncoder(){
return new BCryptPasswordEncoder();
}

@Bean
public SCryptPasswordEncoder sCryptPasswordEncoder(){
return new SCryptPasswordEncoder();
}
}
