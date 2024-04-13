package com.prueba.emsbackend.controller;

import com.prueba.emsbackend.dto.EmpleadoDto;
import com.prueba.emsbackend.service.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoControlador {
    EmpleadoService empleadoService;
    @PostMapping
    public ResponseEntity<EmpleadoDto> aggEmpleado(@RequestBody EmpleadoDto empleadoDto){
        EmpleadoDto empleado_guardado = empleadoService.aggEmpleado(empleadoDto);
        return new ResponseEntity<>(empleado_guardado, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDto> getEmpleadoPorId(@PathVariable("id") Long idEmpleado){
        EmpleadoDto empleadoDto = empleadoService.getEmpleadoPorId(idEmpleado);
        return ResponseEntity.ok(empleadoDto);
    }
    @GetMapping
    public ResponseEntity<List<EmpleadoDto>> getEmpleados(){
        List<EmpleadoDto> empleadosDto = empleadoService.getEmpleados();
        return ResponseEntity.ok(empleadosDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable("id") Long idEmpleado){
        empleadoService.eliminarEmpleado(idEmpleado);
        return ResponseEntity.ok("Empleado eliminado exitosamente");
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDto> actualizarEmpleado(@RequestBody EmpleadoDto empleadoDto,@PathVariable Long id){
        EmpleadoDto empleado_actualizado = empleadoService.actualizarEmpleado(empleadoDto, id);
        return ResponseEntity.ok(empleado_actualizado);
    }
}
