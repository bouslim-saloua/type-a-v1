/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.model.CustomUtilisateurDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@RequiredArgsConstructor
@Service
public class AuthenticationProviderService implements AuthenticationProvider{
    
final JpaUtilisateurDetailsService utilisateurDetailsService;
final BCryptPasswordEncoder bCryptPasswordEncoder;
final SCryptPasswordEncoder sCryptPasswordEncoder;


@Override
public Authentication authenticate(Authentication authentication) throws AuthenticationException{

String username = authentication.getName();
String password = authentication.getCredentials().toString();

    CustomUtilisateurDetails utilisateur = utilisateurDetailsService.loadUserByUsername(username);
    switch (utilisateur.getUtilisateur().getAlgorithm()) {
        case BCRYPT:
            
            return checkPassword(utilisateur, password, bCryptPasswordEncoder);
       case SCRYPT:
            return checkPassword(utilisateur, password, sCryptPasswordEncoder);
    }
throw new BadCredentialsException("Bad credentials");
}



@Override
public boolean supports(Class<?> aClass){
return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
}

private Authentication checkPassword(CustomUtilisateurDetails user, String rawPassword, PasswordEncoder encoder){
if(encoder.matches(rawPassword, user.getPassword())){
return new UsernamePasswordAuthenticationToken(
user.getUsername(),
user.getPassword(),
user.getAuthorities()
);
}else{
throw new BadCredentialsException("Bad credentials");
}
}

}
