/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
@Entity
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id; 
private String name;


@JoinColumn(name = "utilisateur")
@ManyToOne
private Utilisateur utilisateur;
    
}
