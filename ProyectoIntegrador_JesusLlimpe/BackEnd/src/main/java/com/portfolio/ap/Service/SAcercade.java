/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ap.Service;

import com.portfolio.ap.Entity.Acercade;
import com.portfolio.ap.Repository.RAcercade;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcercade {
    @Autowired
    RAcercade rAcercade;


    public Optional<Acercade> getOne(int id){
        return rAcercade.findById(id);
    }

    public void save(Acercade acercade){
        rAcercade.save(acercade);
    }
    
}
