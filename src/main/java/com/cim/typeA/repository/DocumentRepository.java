/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.repository;

import com.cim.typeA.model.Document;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, String>{
    
@Query(value="SELECT * FROM Document m WHERE m.manifestation_id = :manifestationId ", nativeQuery = true)
public List<Document> findAllDocumentsByManifestation(@Param("manifestationId") Long manifestationId);

}
