/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ap.Service;

import com.portfolio.ap.Entity.Proyectos;
import com.portfolio.ap.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
    @Autowired
    RProyectos rProyectos;

    public List<Proyectos> list(){
        return rProyectos.findAll();
    }

    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }

    public Optional<Proyectos> getByNombrePr(String nombrePr){
        return rProyectos.findByNombrePr(nombrePr);
    }

    public void save(Proyectos pro){
        rProyectos.save(pro);
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);
    }

    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }

    public boolean existsByNombrePr(String nombrePr){
        return rProyectos.existsByNombrePr(nombrePr);
    }
}
