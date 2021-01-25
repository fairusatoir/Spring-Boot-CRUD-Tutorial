/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework1.controller;

import com.example.Framework1.models.Department;
import com.example.Framework1.models.Employee;
import com.example.Framework1.repositories.DepartmentRepository;
import com.example.Framework1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeRepository er;

    @Autowired
    DepartmentRepository departmentRepo;
    
//    @GetMapping("/all")
//    public String mainEmployee(Model model){
//        model.addAttribute("departments", departmentRepo.findAll());
//        model.addAttribute("employees", er.findAll());
//        model.addAttribute("employee", new Employee());
//        return("employee");
//    }

    @GetMapping("/{id}")
    public String getEmployeeByDepartment(Model model, @PathVariable("id") String id){
        //Get All Employee by Department
        model.addAttribute("employees", er.findByDepartmentId(id));
        model.addAttribute("employee", new Employee());
        model.addAttribute("departmentID", departmentRepo.findById(id).get());
        return("employee");
    }

    //Create and Update Department
    @PostMapping("/save/{idDerp}")
    public String employeeFormSave(Employee employee,
                                   @PathVariable("idDerp") String idDerp){
        Optional<Department> department = departmentRepo.findById(idDerp);
        employee.setDepartment(department.get());
        er.save(employee);
        return "redirect:/employee/"+idDerp;
    }

    //Delete Department
    @GetMapping("/delete/{idDep}/{id}")
    public String deleteEmployee(
            Employee employee,
            @PathVariable("id") String id,
            @PathVariable("idDep") String idDep){
        er.deleteById(id);
        return "redirect:/employee/"+idDep;
    }

}
