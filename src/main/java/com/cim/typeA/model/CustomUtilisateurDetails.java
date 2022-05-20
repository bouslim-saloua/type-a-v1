/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author USER
 */

public class CustomUtilisateurDetails implements UserDetails{
@JsonIgnore
     private final Utilisateur utilisateur;

public CustomUtilisateurDetails(Utilisateur utilisateur){
this.utilisateur = utilisateur;
}

public final Utilisateur getUtilisateur(){
return utilisateur;
}

//Omitted code

@Override
public Collection<? extends GrantedAuthority> getAuthorities(){
return utilisateur.getAuthorities().stream()
.map(a -> new SimpleGrantedAuthority(
a.getName())).collect(Collectors.toList());
}

@Override
public String getPassword(){
return utilisateur.getPassword();
}

@Override
public String getUsername(){
return utilisateur.getEmail();
}

@Override
public boolean isAccountNonExpired(){
return true;
}

@Override
public boolean isAccountNonLocked(){
return true;
}

@Override
public boolean isCredentialsNonExpired(){
return true;
}

@Override
public boolean isEnabled(){
return true;
}

}
