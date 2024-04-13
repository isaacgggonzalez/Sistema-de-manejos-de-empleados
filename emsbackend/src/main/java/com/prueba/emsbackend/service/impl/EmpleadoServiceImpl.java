package com.prueba.emsbackend.service.impl;

import com.prueba.emsbackend.dto.EmpleadoDto;
import com.prueba.emsbackend.entity.Empleado;
import com.prueba.emsbackend.exception.ResourceNotFoundException;
import com.prueba.emsbackend.mapper.EmpleadoMapper;
import com.prueba.emsbackend.repositorio.EmpleadoRepositorio;
import com.prueba.emsbackend.service.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService{
    EmpleadoRepositorio empleadoRepositorio;
    @Override
    public EmpleadoDto aggEmpleado(EmpleadoDto empleadoDto) {
        Empleado empleado = EmpleadoMapper.EmpleadoDto_a_Empleado(empleadoDto);
        Empleado empleado_guardado = empleadoRepositorio.save(empleado);
        return EmpleadoMapper.Empleado_a_EmpleadoDto(empleado_guardado);
    }

    @Override
    public EmpleadoDto getEmpleadoPorId(Long idEmpleado) {
        Empleado empleado = empleadoRepositorio.findById(idEmpleado)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró un empleado con el id " + idEmpleado));
        return EmpleadoMapper.Empleado_a_EmpleadoDto(empleado);
    }

    @Override
    public List<EmpleadoDto> getEmpleados() {
        List<Empleado> empleados = empleadoRepositorio.findAll();
        return empleados.stream().map(EmpleadoMapper::Empleado_a_EmpleadoDto).collect(Collectors.toList());
    }

    @Override
    public void eliminarEmpleado(Long id) {
        Empleado empleado = empleadoRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("El empleado con el id" + id + "no existe"));
        empleadoRepositorio.deleteById(id);
    }

    @Override
    public EmpleadoDto actualizarEmpleado(EmpleadoDto empleadoDto, Long id) {
        Empleado empleado = empleadoRepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Empleado no encontrado con el id dado"));
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setApellido(empleadoDto.getApellido());
        empleado.setEmail(empleadoDto.getEmail());
        Empleado empleado_guardado = empleadoRepositorio.save(empleado);
        return EmpleadoMapper.Empleado_a_EmpleadoDto(empleado_guardado);
    }
}
