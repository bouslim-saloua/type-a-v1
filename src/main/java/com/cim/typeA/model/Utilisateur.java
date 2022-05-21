/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author HP
 */

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



@OneToMany(mappedBy="utilisateur", fetch = FetchType.EAGER)
private Set<Role> roles;



/*public Utilisateur(String nom, String prenom,String email, String password, String telephone){
this.nom = nom;
this.prenom = prenom;
this.email = email;
this.password = password;
this.telephone = telephone;
}*/
public Utilisateur( String email, String password) {
		
		this.email = email;
		this.password = password;
	}

public Utilisateur(){
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }




}
