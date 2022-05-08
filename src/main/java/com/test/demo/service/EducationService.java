/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.demo.service;

import com.test.demo.model.Education;
import com.test.demo.repository.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ari
 */
@Service
public class EducationService implements IEducationService {
    
    @Autowired
    private EducationRepository educationRepository;
    
    @Override
    public List<Education> getEducation() {
      List<Education> listaPersonas = educationRepository.findAll();
      return listaPersonas;
    }

    @Override
    public Education saveEducation(Education perso) {
        return educationRepository.save(perso);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        Education perso = educationRepository.findById(id).orElse(null);
        return perso;
    }
}
