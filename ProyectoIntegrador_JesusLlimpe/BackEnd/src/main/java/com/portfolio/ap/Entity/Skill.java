/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSk;
    private String dominioSk;


    //Constructores

    public Skill() {
    }

    public Skill(String nombreSk, String dominioSk) {
        this.nombreSk = nombreSk;
        this.dominioSk = dominioSk;
    }

    //Getter y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    