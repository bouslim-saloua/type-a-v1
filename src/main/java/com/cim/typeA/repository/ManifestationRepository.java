/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cim.typeA.model.Manifestation;
import com.cim.typeA.payload.holder.ManifestationHolderResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author HP
 */
@Repository
public interface ManifestationRepository extends JpaRepository<Manifestation, Long> {
    

///Costumized queries
@Query(value="SELECT m FROM Manifestation m WHERE m.status='refusée'")
public List<Manifestation> findAllRefused();

@Query(value="SELECT m FROM Manifestation m WHERE m.status = 'validée'")
public List<Manifestation> findAllAccepted();

@Query(value="SELECT m FROM Manifestation m WHERE m.status = 'en cours'")
public List<Manifestation> findAllInProgress();

@Query(value="SELECT COUNT(id) FROM Manifestation")
public Long countAll();

@Query(value="SELECT COUNT(m.id) FROM Manifestation m WHERE m.status='refusée'")
public Long countAllRefused();

@Query(value="SELECT COUNT(m.id) FROM Manifestation m WHERE m.status='validée'")
public Long countAllAccepted();

@Query(value="SELECT COUNT(m.id) FROM Manifestation m WHERE m.status='en cours'")
public Long countAllInProgress();

/*@Query(value="SELECT m FROM Manifestation ORDER BY m.date_creation ASC")
public List<Manifestation> findAllByDateCreation();*/

@Query(value="SELECT * FROM Manifestation m WHERE m.utilisateur_id = :utilisateurId ", nativeQuery = true)
public List<Manifestation> findAllByUtilisateurId(@Param("utilisateurId") Long utilisateurId);


@Query(value="SELECT u.nom, u.prenom , u.email, u.telephone, dp.fonctionnalite,dp.grade,dp.salarie, dp.annee_these,dp.directeur_these,dp.ced, dp.etablissement,dp.departement, dp.entite_recherche,dp.respo_entite, m.id, m.date_creation, m.date_debut, m.date_fin, m.date_depart, m.date_retour, m.nature_participation, m.pays, m.titre_manifestation, m.titre_participation, m.ville, s.m_autre soutien,s.m_frais_inscription,s.m_hebergement, s.m_titre_transport, s.m_total, s.nature FROM utilisateur u, manifestation m, donnee_pro dp, soutien s WHERE s.manifestation_id = m.id and m.utilisateur_id = u.id and m.id = dp.manifestation_id and m.id = :id", nativeQuery = true)
public ManifestationHolderResponse findManifestById(Long id);
}
