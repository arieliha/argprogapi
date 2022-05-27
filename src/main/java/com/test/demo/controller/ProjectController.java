/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.demo.controller;

import com.test.demo.model.Project;
import com.test.demo.service.IProjectService;
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
public class ProjectController {
    
    @Autowired
    private IProjectService interProject;
    
    @CrossOrigin(origins = "https://argprog-4b6ba.web.app")
    @GetMapping ("/project/traer")
    
    public List<Project> getProjects() {
        return interProject.getProjects();
    }
    
    @CrossOrigin(origins = "https://argprog-4b6ba.web.app")
    //@PostMapping ("/experience/crear")
    @PostMapping ( value = "/project/crear", consumes = "application/json", produces="application/json")

    public Project createExperience(@RequestBody Project pr) {
        
        return interProject.saveProject(pr);
        // return "La experiencia fue creada correctamente";
    }
    
    @CrossOrigin(origins = "https://argprog-4b6ba.web.app")
    @DeleteMapping ("/project/borrar/{id}")
    public ResponseEntity<Object> deleteProject (@PathVariable Long id) {
    
        interProject.deleteProject(id);
        return ResponseEntity.noContent().build();
        
    }
    
    @CrossOrigin(origins = "https://argprog-4b6ba.web.app")
    @PutMapping ("/project/editar/{id}")
    public Project editProject (@PathVariable Long id,
            
                                @RequestBody Project RequestProject
    ) 
                                {
    
        Project perso = interProject.findProject(id);
        
        perso.setTitle(RequestProject.getTitle());
        perso.setDate(RequestProject.getDate());
        perso.setDescription(RequestProject.getDescription());
        perso.setLink(RequestProject.getLink());
        perso.setOrder_project(RequestProject.getOrder_project());
        
        interProject.saveProject(perso);
        return perso;
    }
}