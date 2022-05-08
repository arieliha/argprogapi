/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.demo.controller;

import com.test.demo.model.Experience;
import com.test.demo.service.IExperienceService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ariel
 */
@RestController
public class ExperienceController {
    
    @Autowired
    private IExperienceService interExperience;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/experience/traer")
    public List<Experience> getExperiences() {
        return interExperience.getExperiences();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    //@PostMapping ("/experience/crear")
    @PostMapping ( value = "/experience/crear", consumes = "application/json", produces="application/json")

    public Experience createExperience(@RequestBody Experience exp) {
        
        return interExperience.saveExperience(exp);
        // return "La experiencia fue creada correctamente";
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/experience/borrar/{id}")
    public ResponseEntity<Object> deleteExperience (@PathVariable Long id) {
    
        interExperience.deleteExperience(id);
        return ResponseEntity.noContent().build();
        
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/experience/editar/{id}")
    public Experience editExperience (@PathVariable Long id,
            
                                @RequestBody Experience RequestExperience
    ) 
                                {
    
        Experience perso = interExperience.findExperience(id);
        
        perso.setTitle(RequestExperience.getTitle());
        perso.setPeriod(RequestExperience.getPeriod());
        perso.setDescription(RequestExperience.getDescription());
        perso.setOrder_experience(RequestExperience.getOrder_experience());
        
        interExperience.saveExperience(perso);
        return perso;
    }
}
