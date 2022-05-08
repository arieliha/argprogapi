/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.test.demo.service;

import com.test.demo.model.Experience;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface IExperienceService {
    
    public List <Experience> getExperiences ();
    
    public Experience saveExperience (Experience perso);
    
    public void deleteExperience (Long id);
    
    public Experience findExperience (Long id);
}
