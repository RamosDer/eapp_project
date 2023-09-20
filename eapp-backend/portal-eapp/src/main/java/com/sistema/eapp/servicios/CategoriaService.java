/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.servicios;

import com.sistema.eapp.modelo.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Categoria guardarCategoria(Categoria categoria);

    Optional<Categoria> obtenerCategoriaById(Long id);

    List<Categoria> listarTodos();

    void eliminarCategoria(Long id);

}
