/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.service;

import com.cim.typeA.model.MissionStage;
import java.util.List;
/**
 *
 * @author HP
 */
public interface MissionStageService {
  MissionStage save(MissionStage missionStage) throws Exception;

 MissionStage valider(MissionStage missionStage) throws Exception;

MissionStage refuser(MissionStage missionStage) throws Exception;

MissionStage update(MissionStage missionStage) throws Exception;
Long delete(Long id) throws Exception;
List<MissionStage> findAll();
List<MissionStage> findAllRefused();

List<MissionStage> findAllAccepted();

List<MissionStage> findAllInProgress();
Long countAll();

Long countAllRefused();

 Long countAllAccepted();
Long countAllInProgress();
}
