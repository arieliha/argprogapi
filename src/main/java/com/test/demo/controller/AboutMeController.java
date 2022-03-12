/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.demo.controller;
import com.test.demo.model.AboutMe;
import com.test.demo.service.IAboutMeService;
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
 * @author ariel
 */
@RestController
public class AboutMeController {
    
    @Autowired
    private IAboutMeService interAboutMe;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/aboutme/traer")
    public List<AboutMe> getPersonas() {
        return interAboutMe.getAboutMe();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    // @PostMapping ("/aboutme/crear")
    @PostMapping ( value = "/aboutme/crear", consumes = "application/json", produces="application/json")
    public AboutMe createStudent(@RequestBody AboutMe perso) {
        
        return interAboutMe.saveAboutMe(perso);
        //return "La persona fue creada correctamente";
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/aboutme/borrar/{id}")
    public ResponseEntity<Object> deletePersona (@PathVariable Long id) {
    
        interAboutMe.deleteAboutMe(id);
        // return "La persona fue eliminada correctamente";
        return ResponseEntity.noContent().build();
    }
}
