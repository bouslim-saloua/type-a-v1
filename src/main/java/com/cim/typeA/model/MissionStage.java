/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

//@
@Temporal(TemporalType.DATE)
private Date dateCreation; 
//Intitulé mission ou stage

private String titre;


private String respoMarocain;

private String partenaireEtranger;


@Temporal(TemporalType.DATE)
private Date dateDebut;

@Temporal(TemporalType.DATE)
private Date dateFin;

@Temporal(TemporalType.DATE)
private Date dateDepart;

@Temporal(TemporalType.DATE)
private Date dateRetour;

private Boolean hasCurrentTypeA;

private String cadreSoutien;

private String status;


private String pays;

private String ville;

private String objet;


@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "utilisateur_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
@JsonBackReference
private Demandeur demandeur;

/*@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "donneepro_id", nullable = true)
    private DonneePro donneePro;*/

@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "missionStage")
    private DonneePro donneePro;


 @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "missionStage")
    private Soutien soutien;

 
}
