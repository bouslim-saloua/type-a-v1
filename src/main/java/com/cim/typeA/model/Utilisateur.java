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
@Data
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
private List<Authority> authorities;



/*public Utilisateur(String nom, String prenom,String email, String password, String telephone){
this.nom = nom;
this.prenom = prenom;
this.email = email;
this.password = password;
this.telephone = telephone;
}*/
//Constructeur par defaut


}
