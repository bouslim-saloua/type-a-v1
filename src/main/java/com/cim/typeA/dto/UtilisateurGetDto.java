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
public class UtilisateurGetDto {


@JsonProperty("id")
private Long id;


@JsonProperty("nom")
    private String nom;

@JsonProperty("prenom")
private String prenom;

@Email
@JsonProperty("email")
private String email;

@JsonProperty("telephone")
private String telephone;
}
