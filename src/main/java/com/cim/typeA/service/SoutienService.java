/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.service;

import com.cim.typeA.model.Soutien;
import java.util.List;
/**
 *
 * @author HP
 */
public interface SoutienService {
    Soutien save(Soutien soutien) throws Exception;
Soutien update(Soutien soutien) throws Exception;
int calculerTotal(Soutien soutien) throws Exception;
int findSumTotalSoutien();
    List<Soutien> findAll();
Long delete(Long id) throws Exception;

}
