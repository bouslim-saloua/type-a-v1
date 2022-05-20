/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cim.typeA.model.Authority;
import java.util.Optional;

/**
 *
 * @author USER
 */

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{
    
    Optional<Authority> findByName(String name);
}
