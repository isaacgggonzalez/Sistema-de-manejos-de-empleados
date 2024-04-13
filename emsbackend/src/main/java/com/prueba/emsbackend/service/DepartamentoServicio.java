package com.prueba.emsbackend.service;

import com.prueba.emsbackend.dto.DepartamentoDto;

import java.util.List;

public interface DepartamentoServicio {
    DepartamentoDto createDepartment(DepartamentoDto departmentDto);

    DepartamentoDto getDepartmentById(Long departmentId);

    List<DepartamentoDto> getAllDepartments();

    DepartamentoDto updateDepartment(Long departmentId, DepartamentoDto updatedDepartment);

    void deleteDepartment(Long departmentId);
}