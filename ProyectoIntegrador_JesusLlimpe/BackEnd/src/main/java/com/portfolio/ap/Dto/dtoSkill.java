/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ap.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkill {
    @NotBlank
    private String nombreSk;
    @NotBlank
    private String dominioSk;

//Constructores

    public dtoSkill() {
    }

    public dtoSkill(String nombreSk, String dominioSk) {
        this.nombreSk = nombreSk;
        this.dominioSk = dominioSk;
    }

//Getters y Setters

    public String getNombreSk() {
        return nombreSk;
    }

    public void setNombreSk(String nombreSk) {
        this.nombreSk = nombreSk;
    }

    public String getDominioSk() {
        return dominioSk;
    }

    public void setDominioSk(String dominioSk) {
        this.dominioSk = dominioSk;
    }
    
    
}
