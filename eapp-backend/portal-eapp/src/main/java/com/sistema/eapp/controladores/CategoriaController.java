/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.controladores;

import com.sistema.eapp.modelo.Categoria;
import com.sistema.eapp.servicios.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/")
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Categoria obtenerCategoria(@PathVariable("id") Long id) {
        return categoriaService.obtenerCategoriaById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoría no encontrada"));
    }

    @GetMapping("/")
    public List<Categoria> listarTodos() {
        return categoriaService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable("id") Long id) {
        categoriaService.eliminarCategoria(id);
    }
}
