/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.payload.holder;

import com.cim.typeA.model.DonneePro;
import com.cim.typeA.model.Manifestation;
import com.cim.typeA.model.Soutien;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class ManifestationHolder {

    DonneePro donneePro;
    Manifestation manifestation;
    Soutien soutien;

public ManifestationHolder(DonneePro donneePro, Manifestation manifestation, Soutien soutien){
this.donneePro  = donneePro;
this.manifestation = manifestation;
this.soutien = soutien;

}

public ManifestationHolder(){
}

    
}
