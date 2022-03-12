/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.demo.service;

import com.test.demo.model.AboutMe;
import com.test.demo.repository.AboutMeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class AboutMeService implements IAboutMeService {

    @Autowired
    private AboutMeRepository aboutMeRepository;
    
    @Override
    public List<AboutMe> getAboutMe() {
        List<AboutMe> listaAboutMe = aboutMeRepository.findAll();
        return listaAboutMe;
    }

    @Override
    public AboutMe saveAboutMe(AboutMe aboutme) {
        return aboutMeRepository.save(aboutme);
    }

    @Override
    public void deleteAboutMe(Long id) {
        aboutMeRepository.deleteById(id);
    }

    @Override
    public AboutMe findAboutMe(Long id) {
        
        AboutMe aboutme = aboutMeRepository.findById(id).orElse(null);
        return aboutme;
    }
    
}
