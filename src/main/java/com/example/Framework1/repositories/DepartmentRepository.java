/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Framework1.repositories;

import com.example.Framework1.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {


    @Query(value = "SELECT d FROM Department d WHERE d.id = :id")
    Department findId(String id);
}
