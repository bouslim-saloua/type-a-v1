/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.repository;

import com.cim.typeA.model.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cim.typeA.model.Role;
import java.util.Optional;

/**
 *
 * @author USER
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    //Optional<Role> findByName(ERole name);
Role findByName(ERole name);
}
