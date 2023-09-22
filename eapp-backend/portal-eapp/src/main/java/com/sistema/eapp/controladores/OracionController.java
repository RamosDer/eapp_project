package com.sistema.eapp.controladores;

import com.sistema.eapp.modelo.Oracion;
import com.sistema.eapp.servicios.OracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/oraciones")
@CrossOrigin("*")
public class OracionController {

    @Autowired
    private OracionService oracionService;

    @PostMapping("/")
    public Oracion guardarOracion(@RequestBody Oracion oracion) {
        return oracionService.guardarOracion(oracion);
    }

    @GetMapping("/{id}")
    public Oracion obtenerOracion(@PathVariable("id") Long id) {
        return oracionService.obtenerPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Oración no encontrada"));
    }

    @GetMapping("/")
    public List<Oracion> listarTodos() {
        return oracionService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void eliminarOracion(@PathVariable("id") Long id) {
        oracionService.eliminarOracion(id);
    }
}
