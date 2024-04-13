package com.prueba.emsbackend.mapper;

import com.prueba.emsbackend.dto.EmpleadoDto;
import com.prueba.emsbackend.entity.Empleado;

public class EmpleadoMapper {
    public static EmpleadoDto Empleado_a_EmpleadoDto(Empleado empleado){
        return new EmpleadoDto(empleado.getId(), empleado.getNombre(), empleado.getApellido(), empleado.getEmail());
    }
    public static Empleado EmpleadoDto_a_Empleado(EmpleadoDto empleadoDto){
        return new Empleado(empleadoDto.getId(), empleadoDto.getNombre(), empleadoDto.getApellido(), empleadoDto.getEmail());
    }
}
