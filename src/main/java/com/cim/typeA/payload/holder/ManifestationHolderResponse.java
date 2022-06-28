/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.payload.holder;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class ManifestationHolderResponse {
   private Date dateCreation;
private String titreManifestation;
private String titreParticipation;
private String pays;
private String ville;
private Date dateDebut;
private Date dateFin;
private Date dateDepart;
private Date dateRetour;
private String natureParticipation;
private String status;
private  Boolean hasBenifitedTypeA;
private int montantAnEnCours;
private int montantAnPrd;

//DonneePro 
private String fonctionnalite;
private String grade;
private Boolean salarie;
private String anneeThese;
private String directeurThese;
private String ced;
private String etablissement;
private String departement;
private String entiteRecherche;
private String respoEntite;
private String type;
//Soutien
private String nature;
private int mTitreTransport;
private int mFraisInscription;
private int mHebergement;
private int mAutre; 
private Long soutienId;
//Demandeur
private String nom;
private String prenom;
private String email;
private String telephone;
}
