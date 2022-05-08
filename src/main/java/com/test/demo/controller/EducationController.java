/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.demo.controller;
import com.test.demo.model.Education;
import com.test.demo.service.IEducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
 * @author ari
 */
@RestController
public class EducationController {
    @Autowired
    private IEducationService interEducation;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/education/traer")
    
    public List<Education> getEducation() {
        return interEducation.getEducation();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    // @PostMapping ("/aboutme/crear")
    @PostMapping ( value = "/education/crear", consumes = "application/json", produces="application/json")
    public Education createEducation(@RequestBody Education educ) {
        
        return interEducation.saveEducation(educ);
        //return "La persona fue creada correctamente";
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/education/borrar/{id}")
    public ResponseEntity<Object> deleteEducation (@PathVariable Long id) {
    
        interEducation.deleteEducation(id);
        // return "La persona fue eliminada correctamente";
        return ResponseEntity.noContent().build();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/education/editar/{id}")
    public Education editEducation (@PathVariable Long id,
                                
                                @RequestBody Education RequestAboutMe
                                // @RequestParam ("fullname") String nuevoNombre,
                                // @RequestParam ("title") String nuevoTitle,
                                // @RequestParam ("picfile") String nuevoPicfile,
                                // @RequestParam ("description") String nuevaDescription
    ) {
    
        Education perso = interEducation.findEducation(id);
        
        
        perso.setTitle(RequestAboutMe.getTitle());
        perso.setInstitute(RequestAboutMe.getInstitute());
        perso.setPeriod(RequestAboutMe.getPeriod());
        perso.setDescription(RequestAboutMe.getDescription());
        perso.setOrder_education(RequestAboutMe.getOrder_education());
        
        interEducation.saveEducation(perso);
        return perso;
    }
}
