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

@NotNull
@Temporal(TemporalType.DATE)
private Date dateCreation;
//intitulé de la manifestation
@NotNull
private String titreManifestation;
@NotNull
private String titreParticipation;
@NotNull
private String pays;
@NotNull
private String ville;
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
private String natureParticipation;
@NotNull
private String status;
@NotNull
private Boolean hasBenifitedTypeA;

private int montantAnEnCours;

//montant année précédente
private int montantAnPrd;

@ManyToOne
private Demandeur demandeur;

 @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "manifestation")
    private Soutien soutien;
}
