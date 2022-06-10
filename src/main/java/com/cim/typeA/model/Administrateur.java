/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

//import lombok.Data;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;




/**
 *
 * @author HP
 */

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Administrateur extends Utilisateur{

    public Administrateur(String nom, String prenom, String telephone, String email, String encode) {
       super(nom, prenom, telephone, email, encode);
    }
public Administrateur(){
}

}
