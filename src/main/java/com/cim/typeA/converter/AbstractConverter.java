/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.converter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public abstract class AbstractConverter  <DM, DTO>{

public abstract DM convertToDM(DTO dto);
public abstract DTO convertToDTO(DM dm);

public List<DM> convertToDMs(List<DTO> dtos){
List<DM> dms = new ArrayList<>();
for (DTO dto : dtos) dms.add(convertToDM(dto));
return dms;
}


public List<DTO> convertToDTOs(List<DM> dms){

List<DTO> dtos = new ArrayList<>();
for(DM dm : dms) dtos.add(convertToDTO(dm));
return dtos;
}
    
}
