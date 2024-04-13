package com.prueba.emsbackend.mapper;

import com.prueba.emsbackend.dto.DepartamentoDto;
import com.prueba.emsbackend.entity.Departamento;

public class DepartamentoMapper {
    public static DepartamentoDto Departamento_a_DepartamentoDto(Departamento departamento){
        return new DepartamentoDto(departamento.getId(), departamento.getNombre(), departamento.getDescripcion());
    }
    public static Departamento DepartamentoDto_a_Departamento(DepartamentoDto departamentoDto){
        return new Departamento(departamentoDto.getId(), departamentoDto.getNombre(), departamentoDto.getDescripcion());
    }
}
