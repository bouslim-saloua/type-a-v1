/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
private String grade;
private Boolean salarie;
private int anneeThese;
private String directeurThese;
private String ced;

private String etablissement;
private String departement;
private String entiteRecherche;
//responsable de l'entité de recherche
private String respoEntite;

@ManyToOne
private Demandeur demandeur;

}
