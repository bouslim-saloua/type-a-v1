/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
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
/*@JsonIgnore
     private final Utilisateur utilisateur;*/
private Collection<? extends GrantedAuthority> authorities;
/*public CustomUtilisateurDetails(Utilisateur utilisateur){
this.utilisateur = utilisateur;
}

public final Utilisateur getUtilisateur(){
return utilisateur;
}*/

//Omitted code
private Long id;
private String nom;
private String prenom;
private String email;
@JsonIgnore
private String password;
private String telephone;

@Override
public Collection<? extends GrantedAuthority> getAuthorities(){
return this.authorities;
}
public CustomUtilisateurDetails(Long id,String nom, String prenom,String telephone, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		
		this.id = id;
this.nom = nom; 
this.prenom = prenom; 
this.telephone  = telephone;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

public static CustomUtilisateurDetails build(Utilisateur user) {
		  List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		return new CustomUtilisateurDetails(
				user.getId(), 
				user.getNom(),
user.getTelephone(),
user.getPassword(),
				user.getEmail(),
				user.getPassword(), 
				authorities);
	}
public String getNom(){
return this.nom;
}

public String getPrenom(){
return this.prenom;
}

public String getEmail(){
return this.email;
}
public String getTelephone(){
return this.telephone;
}
@Override
public String getPassword(){
return this.password;
}
public Long getId(){
return this.id;
}

@Override
public String getUsername(){
return this.email;
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

@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CustomUtilisateurDetails user = (CustomUtilisateurDetails) o;
		return Objects.equals(id, user.id);
	}
}
