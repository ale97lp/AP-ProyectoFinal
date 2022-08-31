/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ap.Controller;

import com.portfolio.ap.Dto.dtoAcercade;
import com.portfolio.ap.Entity.Acercade;
import com.portfolio.ap.Service.SAcercade;
import com.portfolio.ap.Security.Controller.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acercade")
@CrossOrigin(origins = "http://localhost:4200")
public class CAcercade {
    @Autowired
    SAcercade sAcercade;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercade dtoacercade){
        
        Acercade acercade = new Acercade(dtoacercade.getDescripcionA());
        sAcercade.save(acercade);
        return new ResponseEntity(new Mensaje("Descripción agregada"), HttpStatus.OK);       
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercade dtoacercade){
    
        Acercade acercade = sAcercade.getOne(id).get();  
        acercade.setDescripcionA(dtoacercade.getDescripcionA());

        sAcercade.save(acercade);   
        return new ResponseEntity(new Mensaje("Información actualizada"), HttpStatus.OK);
    }

}