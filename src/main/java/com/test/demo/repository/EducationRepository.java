/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.demo.repository;

import com.test.demo.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ari
 */
public interface EducationRepository extends JpaRepository <Education, Long>{
    
}
