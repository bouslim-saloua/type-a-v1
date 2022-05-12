/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.repository;

import com.cim.typeA.model.Soutien;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */

@Repository
public interface SoutienRepository extends JpaRepository<Soutien, Long>{


    
@Query(value="SELECT SUM(s.mTotal) From Soutien s")
public int findSumTotalSoutien();

//more queries



}
