package com.prueba.emsbackend.repositorio;

import com.prueba.emsbackend.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

}
