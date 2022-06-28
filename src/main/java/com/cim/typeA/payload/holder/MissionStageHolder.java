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
public class MissionStageHolder {
  
//MissionStage attributs
private String dateCreation;
private String titre;
private String respoMarocain;
private String partenaireEtranger;
private Date dateDebut;
private Date dateFin;
private Date dateDepart;
private Date dateRetour;
private Boolean hasCurrentTypeA;
private String cadreSoutien;
private String status;
private String pays;
private String ville;
private String objet;
private int montantAnEnCours;
//montant année précédente
private int montantAnPrd;
private String type;

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

