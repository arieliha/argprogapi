/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.test.demo.service;

import com.test.demo.model.AboutMe;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface IAboutMeService {
    
    public List <AboutMe> getAboutMe ();
    
    public AboutMe saveAboutMe (AboutMe perso);
    
    public void deleteAboutMe (Long id);
    
    public AboutMe findAboutMe (Long id);
}
