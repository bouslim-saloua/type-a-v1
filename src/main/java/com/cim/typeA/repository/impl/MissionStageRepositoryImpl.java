/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.transaction.Transactional;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Transactional
@Repository
public class MissionStageRepositoryImpl {
  @Autowired
 @Qualifier("jdbcTemplate")
private JdbcTemplate jdbcTemplate;

@Autowired
private ResourceLoader resourceLoader;

 public JasperPrint exportPdfFile(Long id) throws SQLException, JRException, IOException {
     Connection conn = jdbcTemplate.getDataSource().getConnection();

  String path = resourceLoader.getResource("classpath:mission_stage.jrxml").getURI().getPath();
//File file = new ClassPathResource("data/data.json").getFile();

//String path= file.getAbsolutePath();
     JasperReport jasperReport = JasperCompileManager.compileReport(path);

  // Parameters for report
     Map<String, Object> parameters = new HashMap<String, Object>();
//Fill parameters
parameters.put("idMission", id);
  JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

  return print;
 }  
}
