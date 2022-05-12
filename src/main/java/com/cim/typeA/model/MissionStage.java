/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
@Entity
public class MissionStage implements Serializable{
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;

@NotNull
@Temporal(TemporalType.DATE)
private Date dateCreation; 
//Intitulé mission ou stage
@NotNull
private String titre;
@NotNull
private String cadre;
private String respoMarocain;
private String respoEtranger;
@NotNull
private String lieu;
@NotNull
@Temporal(TemporalType.DATE)
private Date dateDebut;
@NotNull
@Temporal(TemporalType.DATE)
private Date dateFin;
@NotNull
@Temporal(TemporalType.DATE)
private Date dateDepart;
@NotNull
@Temporal(TemporalType.DATE)
private Date dateRetour;
@NotNull
private Boolean hasCurrentTypeA;
@NotNull
private String cadreSoutien;
@NotNull
private String status;

@ManyToOne
private Demandeur demandeur;

 @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "missionStage")
    private Soutien soutien;
}
