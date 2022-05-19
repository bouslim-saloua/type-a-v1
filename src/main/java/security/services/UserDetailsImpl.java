/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security.services;

import com.cim.typeA.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author USER
 */

public class UserDetailsImpl implements UserDetails{
    private static final long serialVersionUID =1L;
private Long id;
private String email;
private String nom;
private String prenom;
private String telephone;
private String username;
@JsonIgnore
private String password;

private Collection<? extends GrantedAuthority> authorities;

public UserDetailsImpl(Long id, String username,String nom, String prenom, String email, String password,
Collection<? extends GrantedAuthority> authorities){
this.id = id;
this.username = username;
this.email = email;
this.password = password;
this.authorities = authorities;
this.nom = nom;
this.prenom = prenom;
}

public static UserDetailsImpl build(Utilisateur utilisateur){
    List<GrantedAuthority> authorities = utilisateur.getRoles().stream()
.map(role -> new SimpleGrantedAuthority(role.getName().name()))
.collect(Collectors.toList());

return new UserDetailsImpl(
utilisateur.getId(),
utilisateur.getNom(),
utilisateur.getPrenom(),
utilisateur.getUsername(),
utilisateur.getEmail(),
utilisateur.getPassword(),
authorities
);
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities(){
return authorities;
}

public Long getId(){
return id;
}

public String getTelephone(){
return telephone;
}
public String getEmail(){
return email;
}

@Override
public String getUsername(){
return username;
}

public String getNom(){
return nom;
}

public String getPrenom(){
return prenom;
}

@Override
public String getPassword(){
return password;
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
}
