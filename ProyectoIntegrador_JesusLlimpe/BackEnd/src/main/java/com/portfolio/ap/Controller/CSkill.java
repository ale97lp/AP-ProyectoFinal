/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ap.Controller;

import com.portfolio.ap.Dto.dtoSkill;
import com.portfolio.ap.Entity.Skill;
import com.portfolio.ap.Security.Controller.Mensaje;
import com.portfolio.ap.Service.SSkill;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "https://frontendlp97.web.app")
public class CSkill {
    @Autowired
    SSkill sSkill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id")int id){
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID(Skill)"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sSkill.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombreSk())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sSkill.existsByNombreSk(dtoskill.getNombreSk())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(dtoskill.getNombreSk(), dtoskill.getDominioSk());
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Skill creada"), HttpStatus.OK);       
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoskill){
        //Validamos si existe el ID
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID(Skill)"), HttpStatus.NOT_FOUND);
        }
        //Compara nombre de educaciones
        if(sSkill.existsByNombreSk(dtoskill.getNombreSk()) && sSkill.getByNombreSk(dtoskill.getNombreSk()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacío
        if(StringUtils.isBlank(dtoskill.getNombreSk())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = sSkill.getOne(id).get();  
        skill.setNombreSk(dtoskill.getNombreSk());
        skill.setDominioSk(dtoskill.getDominioSk());
        
        sSkill.save(skill);   
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
