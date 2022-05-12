/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HP
 */
@Getter
@Setter
public class UtilisateurPostDto {

@JsonProperty("id")
private Long id;

@NotNull(message = "Le nom ne doit pas etre null")
@JsonProperty("nom")
    private String nom;
@NotNull(message = "Le prenom ne doit pas etre null")
@JsonProperty("prenom")
private String prenom;
@NotNull(message = "L'email ne doit pas etre null")
@Email
@JsonProperty("email")
private String email;
@NotNull(message = "Le mot de passe ne doit pas etre null")
@JsonProperty("password")
private String password;
@NotNull(message = "Le telephone ne doit pas etre null")
@JsonProperty("telephone")
private String telephone;
}
