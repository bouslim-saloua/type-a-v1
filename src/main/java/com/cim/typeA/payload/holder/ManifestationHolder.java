/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.payload.holder;

import com.cim.typeA.model.DonneePro;
import com.cim.typeA.model.Manifestation;
import com.cim.typeA.model.Soutien;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class ManifestationHolder {

   /* DonneePro donneePro;
    Manifestation manifestation;
    Soutien soutien;

public ManifestationHolder(DonneePro donneePro, Manifestation manifestation, Soutien soutien){
this.donneePro  = donneePro;
this.manifestation = manifestation;
this.soutien = soutien;

}

public ManifestationHolder(){
}*/
//Manifestation attributs
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

//Soutien
private String nature;
private int mTitreTransport;
private int mFraisInscription;
private int mHebergement;
private int mAutre;

    
}
