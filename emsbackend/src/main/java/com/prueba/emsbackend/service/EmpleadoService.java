package com.prueba.emsbackend.service;

import com.prueba.emsbackend.dto.EmpleadoDto;

import java.util.List;

public interface EmpleadoService {
    public EmpleadoDto aggEmpleado(EmpleadoDto empleadoDto);
    public EmpleadoDto getEmpleadoPorId(Long idEmpleado);
    public List<EmpleadoDto> getEmpleados();
    public void eliminarEmpleado(Long id);
    public EmpleadoDto actualizarEmpleado(EmpleadoDto empleadoDto, Long id);
}
