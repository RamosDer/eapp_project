/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.controladores;

import com.sistema.eapp.modelo.Significado;
import com.sistema.eapp.servicios.SignificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/significados")
@CrossOrigin("*")
public class SignificadoController {

    @Autowired
    private SignificadoService significadoService;

    @PostMapping("/")
    public Significado guardarSignificado(@RequestBody Significado significado) {
        return significadoService.guardarSignificado(significado);
    }

    @GetMapping("/")
    public List<Significado> obtenerTodos() {
        return significadoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Significado obtenerSignificado(@PathVariable("id") Long id) {
        return significadoService.obtenerPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Significado no encontrado"));
    }


    @DeleteMapping("/{id}")
    public void eliminarSignificado(@PathVariable("id") Long id) {
        significadoService.eliminarSignificado(id);
    }
}

