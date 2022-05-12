/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
@Entity
public class Demandeur extends Utilisateur {
@OneToMany(mappedBy="demandeur")
private List<Manifestation> manifestations;

@OneToMany(mappedBy="demandeur")
private List<MissionStage> missions;

@OneToMany(mappedBy="demandeur")
private List<DonneePro> donneePros;

}
