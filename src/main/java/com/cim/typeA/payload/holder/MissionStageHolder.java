/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.payload.holder;

import com.cim.typeA.model.DonneePro;
import com.cim.typeA.model.MissionStage;
import com.cim.typeA.model.Soutien;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class MissionStageHolder {
    private DonneePro donneePro;
    private MissionStage missionStage;
    private Soutien soutien;

public MissionStageHolder(){
}

public MissionStageHolder(DonneePro donneePro, MissionStage missionStage, Soutien soutien){
this.donneePro = donneePro;
this.missionStage = missionStage;
this.soutien = soutien;
}
}

