/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ap.Dto;


public class dtoAcercade {
    
    private String descripcionA;    

//Constructores

    public dtoAcercade() {
    }

    public dtoAcercade(String descripcionA) {

        this.descripcionA = descripcionA;
    }

//Getters y Setters

    public String getDescripcionA() {
        return descripcionA;
    }

    public void setDescripcionA(String descripcionA) {
        this.descripcionA = descripcionA;
    }
}