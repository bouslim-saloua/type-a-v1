/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
@Entity
//@EqualsAndHashCode(callSuper = false)
public class Demandeur extends Utilisateur {


@OneToMany(mappedBy="demandeur", cascade = CascadeType.ALL)
private List<Manifestation> manifestations;


@OneToMany(mappedBy="demandeur", cascade=CascadeType.ALL)
private List<MissionStage> missions;


@OneToMany(mappedBy="demandeur", cascade=CascadeType.ALL)
private List<DonneePro> donneePros;

    public Demandeur(String nom, String prenom, String telephone, String email, String encode) {
       super(nom, prenom, telephone, email, encode);
    }

//Constructeur Par defaut
public Demandeur(){
}
}
