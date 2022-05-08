/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.demo.service;

import com.test.demo.model.Experience;
import com.test.demo.repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class ExperienceService implements IExperienceService {
    
    @Autowired
    private ExperienceRepository experienceRepository;
    
    @Override
    public List<Experience> getExperiences() {
      List<Experience> listaPersonas = experienceRepository.findAll();
      return listaPersonas;
    }

    @Override
    public Experience saveExperience(Experience perso) {
        return experienceRepository.save(perso);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience perso = experienceRepository.findById(id).orElse(null);
        return perso;
    }
    
}
