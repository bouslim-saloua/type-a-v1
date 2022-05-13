/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cim.typeA.model.Manifestation;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP
 */
@Repository
public interface ManifestationRepository extends JpaRepository<Manifestation, Long> {
    
///Costumized queries
@Query(value="SELECT m FROM Manifestation m WHERE m.status='refusée'")
public List<Manifestation> findAllRefused();

@Query(value="SELECT m FROM Manifestation m WHERE m.status = 'acceptée'")
public List<Manifestation> findAllAccepted();

@Query(value="SELECT m FROM Manifestation m WHERE m.status = 'en cours'")
public List<Manifestation> findAllInProgress();

@Query(value="SELECT COUNT(id) FROM Manifestation")
public Long countAll();

@Query(value="SELECT COUNT(m.id) FROM Manifestation m WHERE m.status='refusée'")
public Long countAllRefused();

@Query(value="SELECT COUNT(m.id) FROM Manifestation m WHERE m.status='acceptée'")
public Long countAllAccepted();

@Query(value="SELECT COUNT(m.id) FROM Manifestation m WHERE m.status='en cours'")
public Long countAllInProgress();

@Query(value="SELECT m FROM Manifestation ORDER BY m.dateCreation ASC")
public List<Manifestation> findAllByDateCreation();
}
