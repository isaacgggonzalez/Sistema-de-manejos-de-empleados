package com.prueba.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import com.prueba.emsbackend.dto.DepartamentoDto;
import com.prueba.emsbackend.entity.Departamento;
import com.prueba.emsbackend.exception.ResourceNotFoundException;
import com.prueba.emsbackend.mapper.DepartamentoMapper;
import com.prueba.emsbackend.repositorio.DepartamentoRepositorio;
import com.prueba.emsbackend.service.DepartamentoServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartamentoServicio {

    private DepartamentoRepositorio departmentRepository;

    @Override
    public DepartamentoDto createDepartment(DepartamentoDto departmentDto) {
        Departamento department = DepartamentoMapper.DepartamentoDto_a_Departamento(departmentDto);
        Departamento savedDepartment = departmentRepository.save(department);
        return DepartamentoMapper.Departamento_a_DepartamentoDto(savedDepartment);
    }

    @Override
    public DepartamentoDto getDepartmentById(Long departmentId) {
        Departamento department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId)
        );
        return DepartamentoMapper.Departamento_a_DepartamentoDto(department);
    }

    @Override
    public List<DepartamentoDto> getAllDepartments() {
        List<Departamento> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartamentoMapper.Departamento_a_DepartamentoDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartamentoDto updateDepartment(Long departmentId, DepartamentoDto updatedDepartment) {

        Departamento department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id:"+ departmentId)
        );

        department.setNombre(updatedDepartment.getNombre());
        department.setDescripcion(updatedDepartment.getDescripcion());

        Departamento savedDepartment = departmentRepository.save(department);

        return DepartamentoMapper.Departamento_a_DepartamentoDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId)
        );

        departmentRepository.deleteById(departmentId);
    }
}