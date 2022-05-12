/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur implements Serializable{
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;

@NotNull(message="le nom ne doit pas etre vide")
private String nom;
@NotNull(message="Le prenom ne doit pas etre vide")
private String prenom;

@Email
@NotNull(message="L'email ne doit pas être vide")
private String email;

@NotNull(message="Le mot de passe ne doit pas être vide")
private String password;
@NotNull(message="Le téléphone ne doit pas être vide")
private String telephone;

}
