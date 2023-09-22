package com.sistema.eapp.controladores;

import com.sistema.eapp.modelo.Practica;
import com.sistema.eapp.servicios.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/practicas")
public class PracticaController {

    @Autowired
    private PracticaService practicaService;

    @PostMapping("/")
    public Practica guardarPractica(@RequestBody Practica practica) {
        return practicaService.guardarPractica(practica);
    }

    @GetMapping("/{id}")
    public Practica obtenerPractica(@PathVariable("id") Long id) {
        return practicaService.obtenerPracticaPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Práctica no encontrada"));
    }

    @GetMapping("/")
    public List<Practica> listarTodas() {
        return practicaService.listarTodas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPractica(@PathVariable("id") Long id) {
        practicaService.eliminarPractica(id);
        return ResponseEntity.ok("Práctica eliminada correctamente");
    }

}
