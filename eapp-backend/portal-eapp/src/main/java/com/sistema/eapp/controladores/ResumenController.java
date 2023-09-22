package com.sistema.eapp.controladores;

import com.sistema.eapp.modelo.Resumen;
import com.sistema.eapp.servicios.ResumenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/resumenes")
public class ResumenController {

    @Autowired
    private ResumenService resumenService;

    @PostMapping("/")
    public Resumen guardarResumen(@RequestBody Resumen resumen) {
        return resumenService.guardarResumen(resumen);
    }

    @GetMapping("/{id}")
    public Resumen obtenerResumen(@PathVariable("id") Long id) {
        return resumenService.obtenerResumenPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resumen no encontrado"));
    }

    @GetMapping("/")
    public List<Resumen> listarTodos() {
        return resumenService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void eliminarResumen(@PathVariable("id") Long id) {
        resumenService.eliminarResumen(id);
    }

    // agregar más endpoints si se necesita.
}
