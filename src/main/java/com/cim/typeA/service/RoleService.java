/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.service;

import com.cim.typeA.model.ERole;
import com.cim.typeA.model.Role;
import java.util.Optional;

/**
 *
 * @author USER
 */
public interface RoleService {
     Role findByName(ERole name);
Role save(Role role);

}
