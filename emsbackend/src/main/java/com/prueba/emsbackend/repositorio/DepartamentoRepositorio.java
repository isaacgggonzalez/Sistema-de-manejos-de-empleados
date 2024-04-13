package com.prueba.emsbackend.repositorio;


import com.prueba.emsbackend.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {

}
