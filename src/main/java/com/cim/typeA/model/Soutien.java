/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

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

 @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manifestation_id", nullable = false)
    private Manifestation manifestation;

 @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mission_stage_id", nullable = false)
    private MissionStage missionStage;
}
