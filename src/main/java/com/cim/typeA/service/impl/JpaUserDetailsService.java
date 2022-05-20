/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.model.CustomUtilisateurDetails;
import com.cim.typeA.model.Utilisateur;
import com.cim.typeA.repository.UtilisateurRepository;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService{
    
final UtilisateurRepository utilisateurRepository;

@Override
public CustomUtilisateurDetails loadUserByUsername(String username){
    Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication!");

Utilisateur utilisateur = utilisateurRepository.findByEmail(username).orElseThrow(s);
return new CustomUtilisateurDetails(utilisateur);
}
}
