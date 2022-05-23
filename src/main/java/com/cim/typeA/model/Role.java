/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Role implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;

@Enumerated(EnumType.STRING)
	@Column(length = 20)
private ERole name;


/*@JoinColumn(name = "utilisateur")
@ManyToOne
private Utilisateur utilisateur;*/
    
}
