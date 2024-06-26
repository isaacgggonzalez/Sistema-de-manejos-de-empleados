package com.prueba.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmpleadoDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

}
