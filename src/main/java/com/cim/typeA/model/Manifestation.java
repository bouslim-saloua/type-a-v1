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
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
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


@Temporal(TemporalType.DATE)
private Date dateCreation;
//intitulé de la manifestation

private String titreManifestation;

private String titreParticipation;

private String pays;

private String ville;

@Temporal(TemporalType.DATE)
private Date dateDebut;

@Temporal(TemporalType.DATE)
private Date dateFin;

@Temporal(TemporalType.DATE)
private Date dateDepart;


@Temporal(TemporalType.DATE)
private Date dateRetour;

private String natureParticipation;

private String status;

private Boolean hasBenifitedTypeA;

private int montantAnEnCours;

//montant année précédente
private int montantAnPrd;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "utilisateur_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
private Demandeur demandeur;

 @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "manifestation")
    private Soutien soutien;
}
