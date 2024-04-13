package com.prueba.emsbackend.controller;

import lombok.AllArgsConstructor;
import com.prueba.emsbackend.dto.DepartamentoDto;
import com.prueba.emsbackend.service.DepartamentoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartamentoController {

    private DepartamentoServicio departmentService;

    // Build Create or Add Department REST API
    @PostMapping
    public ResponseEntity<DepartamentoDto> createDepartment(@RequestBody DepartamentoDto departmentDto){
        DepartamentoDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartamentoDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartamentoDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    // Build Get All Departments REST API
    @GetMapping
    public ResponseEntity<List<DepartamentoDto>> getAllDepartments(){
        List<DepartamentoDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    // Build Update Department REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartamentoDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartamentoDto updatedDepartment){
        DepartamentoDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);
        return ResponseEntity.ok(departmentDto);
    }

    // Build Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully!.");
    }

}