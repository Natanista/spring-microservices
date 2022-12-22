package com.example.departmentservice.controller;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(
            @RequestBody Department department){
        log.info("inside saveDepartment in DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("inside findDepartmentById in DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping
    public List<Department> findAllDepartments(){
        log.info("inside findAllDepartments in DepartmentController");
        return departmentService.findAllDepartments();
    }
}
