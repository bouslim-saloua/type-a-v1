/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
@Entity
public class DonneePro implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
private String fonctionnalite;
//doctorant ou enseignant chercheur
private String type;
private String grade;
private Boolean salarie;
private String anneeThese;
private String directeurThese;
private String ced;

private String etablissement;
private String departement;
private String entiteRecherche;
//responsable de l'entité de recherche
private String respoEntite;



@OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "manifestation_id", nullable = true)
@JsonBackReference
    private Manifestation manifestation;

@OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "mission_id", nullable = true)
@JsonBackReference
    private MissionStage missionStage;


@JsonBackReference(value ="donneePro-manifestation")
public Manifestation getManifestation(){
return this.manifestation;
}

@JsonBackReference(value="donneePro-missionStage")
public MissionStage getMissionStage(){
return this.missionStage;
}

}
