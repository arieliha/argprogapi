/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.test.demo.service;

import com.test.demo.model.Education;
import java.util.List;

/**
 *
 * @author ari
 */
public interface IEducationService {
    public List <Education> getEducation ();
    
    public Education saveEducation (Education perso);
    
    public void deleteEducation (Long id);
    
    public Education findEducation (Long id);
}
