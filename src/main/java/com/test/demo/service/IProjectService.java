/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.test.demo.service;

import com.test.demo.model.Project;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface IProjectService {
    
    public List <Project> getProjects ();
    
    public Project saveProject (Project perso);
    
    public void deleteProject (Long id);
    
    public Project findProject (Long id);
}