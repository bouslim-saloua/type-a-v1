/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author HP
 */
@Data

@NoArgsConstructor
@Entity
public class Utilisateur implements Serializable{
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;

@NotNull
private String nom;
@NotNull
private String prenom;


@Email
@NotNull
private String email;

@NotNull
private String password;
@NotNull
private String telephone;

@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="utilisateur_id"),
inverseJoinColumns = @JoinColumn(name="role_id"))
private Set<Role> roles = new HashSet<>();


public Utilisateur(String nom, String prenom, String email, String password){
this.nom = nom;
this.prenom = prenom;
this.email = email;
this.password = password;
}
}
