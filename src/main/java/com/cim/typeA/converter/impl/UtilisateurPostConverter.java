/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.converter.impl;

import com.cim.typeA.model.Utilisateur;
import com.cim.typeA.dto.UtilisateurPostDto;
import com.cim.typeA.converter.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;


/**
 *
 * @author HP
 */

@Component
public class UtilisateurPostConverter extends AbstractConverter<Utilisateur, UtilisateurPostDto>{
    private final ModelMapper modelMapper;

public UtilisateurPostConverter(ModelMapper modelMapper){
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
this.modelMapper = modelMapper;
}

//From dto to model
@Override
public Utilisateur convertToDM(UtilisateurPostDto utilisateurPostDto){
return modelMapper.map(utilisateurPostDto, Utilisateur.class);
}

//From model to dto
@Override
public UtilisateurPostDto convertToDTO(Utilisateur utilisateur){
return modelMapper.map(utilisateur, UtilisateurPostDto.class);
}

}
