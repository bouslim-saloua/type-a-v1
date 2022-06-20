/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author HP
 */
@Data
@Entity
public class Manifestation implements Serializable {
    
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
/*@Temporal(TemporalType.DATE)
@JsonFormat(pattern="yyyy-MM-dd")
private Date dateCreation;*/
//intitulé de la manifestation
@Temporal(TemporalType.DATE)
@JsonFormat(pattern="yyyy-MM-dd")
private Date dateCreation;
private String titreManifestation;

private String titreParticipation;

private String pays;

private String ville;

@Temporal(TemporalType.DATE)
 //@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
@JsonFormat(pattern="yyyy-MM-dd")
private Date dateDebut;

@Temporal(TemporalType.DATE)
 @JsonFormat(pattern="yyyy-MM-dd")
private Date dateFin;

@Temporal(TemporalType.DATE)
@JsonFormat(pattern="yyyy-MM-dd")
private Date dateDepart;

@Temporal(TemporalType.DATE)
 @JsonFormat(pattern="yyyy-MM-dd")
private Date dateRetour;

private String natureParticipation;

private String status;

private Boolean hasBenifitedTypeA;

private int montantAnEnCours;

//montant année précédente
private int montantAnPrd;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "utilisateur_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private Demandeur demandeur;


@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "manifestation")
//@JsonIgnore
@JsonManagedReference
    private DonneePro donneePro;


 @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "manifestation")
@JsonManagedReference
//@JsonIgnore
    private Soutien soutien;


@JsonManagedReference(value="donneePro-manifestation")
public DonneePro getDonneePro(){
return this.donneePro;
}

@JsonManagedReference(value="soutien-manifestation")
public Soutien getSoutien(){
return this.soutien;
}

@JsonBackReference(value="demandeur-demande")
public Demandeur getDemandeur(){
return this.demandeur;
}
}
