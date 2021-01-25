/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework1.controller;

import com.example.Framework1.models.Department;
import com.example.Framework1.repositories.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author p4nda
 */

@Controller
@RequestMapping("/department")
public class MainController {
    
    @Autowired
    DepartmentRepository departmentRepo;

    //Get All Department List
    @GetMapping("")
    public String main(Model model){
        model.addAttribute("departments", departmentRepo.findAll());
        model.addAttribute("department", new Department());
//        System.out.println("Print");
        return("index");
    }

    //Get Department Attribut by ID
//    @GetMapping("/get/{id}")
//    public String getById(Model model, @PathVariable("id") String id){
//        model.addAttribute("departments", departmentRepo.findAll());
//        model.addAttribute("department", departmentRepo.findById(id).get());
//        return("index");
//    }

    //Create and Update Department
    @PostMapping("/save")
    public String departmentFormSave(Department department){
        departmentRepo.save(department);
        return "redirect:/department";
    }

    //Delete Department
    @GetMapping("/delete/{id}")
    public String deleteDepartment(Department department, @PathVariable("id") String id){
        departmentRepo.deleteById(id);
        return "redirect:/department";
    }
}
