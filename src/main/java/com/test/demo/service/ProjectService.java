/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.demo.service;

import com.test.demo.model.Project;
import com.test.demo.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class ProjectService implements IProjectService {
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Override
    public List<Project> getProjects() {
      List<Project> listaProjects = projectRepository.findAll();
      return listaProjects;
    }

    @Override
    public Project saveProject(Project pr) {
        return projectRepository.save(pr);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        Project pr = projectRepository.findById(id).orElse(null);
        return pr;
    }
    
}