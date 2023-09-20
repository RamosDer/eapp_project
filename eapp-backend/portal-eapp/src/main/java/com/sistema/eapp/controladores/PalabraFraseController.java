/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.controladores;

import com.sistema.eapp.modelo.PalabraFrase;
import com.sistema.eapp.servicios.PalabraFraseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/palabrasfrases")
public class PalabraFraseController {

    @Autowired
    private PalabraFraseService palabraFraseService;

    @PostMapping("/")
    public PalabraFrase guardarPalabraFrase(@RequestBody PalabraFrase palabraFrase) {
        return palabraFraseService.guardarPalabraFrase(palabraFrase);
    }

    @GetMapping("/{id}")
    public PalabraFrase obtenerPalabraFrase(@PathVariable("id") Long id) {
        return palabraFraseService.obtenerPalabraFraseById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Palabra/Frase no encontrada"));
    }

    @GetMapping("/")
    public List<PalabraFrase> listarTodos() {
        return palabraFraseService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void eliminarPalabraFrase(@PathVariable("id") Long id) {
        palabraFraseService.eliminarPalabraFrase(id);
    }

    @PutMapping("/actualizarAprendido/{id}")
    public ResponseEntity<String> actualizarAprendido(@PathVariable("id") Long id, @RequestParam("aprendido") boolean aprendido) {
        PalabraFrase palabraFrase = palabraFraseService.obtenerPalabraFraseById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Palabra/Frase no encontrada"));

        palabraFrase.setAprendido(aprendido);
        palabraFraseService.guardarPalabraFrase(palabraFrase);

        return ResponseEntity.ok("Campo 'aprendido' actualizado correctamente");
    }
}
