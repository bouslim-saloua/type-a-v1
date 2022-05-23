/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.payload.response;

import java.util.List;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class JwtResponse {
      private String token;
  private String type = "Bearer";
  private Long id;
  //private String username;
  private String email;
  private List<String> roles;
private String nom;
private String prenom;
private String telephone;


  public JwtResponse(String accessToken, Long id, String email, String nom, String prenom,String telephone ,List<String> roles) {
    this.token = accessToken;
    this.id = id;
   
    this.email = email;
    this.roles = roles;
this.nom = nom;
this.prenom  = prenom;
this.telephone = telephone;
  }

    /*public JwtResponse(String jwt, Long id, String username, List<String> roles) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
