/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author HP
 */
@Data
@Entity
public class Soutien implements Serializable{
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
private String nature;
private int mTitreTransport;
private int mFraisInscription;
private int mHebergement;
private int mAutre;
private int mTotal;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "manifestation_id", referencedColumnName = "id")
@NotFound(action = NotFoundAction.IGNORE)
    private Manifestation manifestation;

 @OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "mission_stage_id", referencedColumnName = "id")
@NotFound(action = NotFoundAction.IGNORE)
    private MissionStage missionStage;
}
