/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cim.typeA.model.Demandeur;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author HP
 */

@Repository
public interface DemandeurRepository extends JpaRepository<Demandeur, Long>{
    
@Query(value = "SELECT d FROM Demandeur d ORDER BY dateCreation Asc")
public List<Demandeur> findAllSortedByDateCreation();
}
