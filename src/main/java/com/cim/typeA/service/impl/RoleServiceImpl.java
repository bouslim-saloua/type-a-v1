/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.model.ERole;
import com.cim.typeA.model.Role;
import com.cim.typeA.repository.RoleRepository;
import com.cim.typeA.service.RoleService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    final RoleRepository roleRepository;

@Override
public   Role findByName(ERole name){
return  roleRepository.findByName(name);
}
@Override
public Role save(Role role){
return roleRepository.save(role);
}

}
