/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.repository;

import com.cim.typeA.model.MissionStage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

@Query(value="SELECT m FROM MissionStage m WHERE m.status = 'validée'")
public List<MissionStage> findAllAccepted();

@Query(value="SELECT m FROM MissionStage m WHERE m.status = 'en cours'")
public List<MissionStage> findAllInProgress();

@Query(value="SELECT COUNT(id) FROM MissionStage")
public Long countAll();

@Query(value="SELECT COUNT(m.id) FROM MissionStage m WHERE m.status='refusée'")
public Long countAllRefused();

@Query(value="SELECT COUNT(m.id) FROM MissionStage m WHERE m.status='validée'")
public Long countAllAccepted();

@Query(value="SELECT COUNT(m.id) FROM MissionStage m WHERE m.status='en cours'")
public Long countAllInProgress();

/*@Query(value="SELECT m FROM MissionStage ORDER BY m.date_creation ASC")
public List<MissionStage> findAllByDateCreation();*/
@Query(value="SELECT * FROM mission_stage m WHERE m.utilisateur_id = :utilisateurId ", nativeQuery = true)
public List<MissionStage> findAllByUtilisateurId(@Param("utilisateurId") Long utilisateurId);
}
