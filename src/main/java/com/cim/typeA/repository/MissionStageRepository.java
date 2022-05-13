/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.repository;

import com.cim.typeA.model.MissionStage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */

@Repository
public interface MissionStageRepository extends JpaRepository<MissionStage, Object>{
    ///Costumized queries
@Query(value="SELECT m FROM MissionStage m WHERE m.status='refusée'")
public List<MissionStage> findAllRefused();

@Query(value="SELECT m FROM MissionStage m WHERE m.status = 'acceptée'")
public List<MissionStage> findAllAccepted();

@Query(value="SELECT m FROM MissionStage m WHERE m.status = 'en cours'")
public List<MissionStage> findAllInProgress();

@Query(value="SELECT COUNT(id) FROM MissionStage")
public Long countAll();

@Query(value="SELECT COUNT(m.id) FROM MissionStage m WHERE m.status='refusée'")
public Long countAllRefused();

@Query(value="SELECT COUNT(m.id) FROM MissionStage m WHERE m.status='acceptée'")
public Long countAllAccepted();

@Query(value="SELECT COUNT(m.id) FROM MissionStage m WHERE m.status='en cours'")
public Long countAllInProgress();

@Query(value="SELECT m FROM MissionStage ORDER BY m.dateCreation ASC")
public List<MissionStage> findAllByDateCreation();
}
