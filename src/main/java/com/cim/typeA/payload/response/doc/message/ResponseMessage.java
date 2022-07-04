/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.payload.response.doc.message;

import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class ResponseMessage {
    private String message;

public ResponseMessage(String message){
this.message = message;
}
}
