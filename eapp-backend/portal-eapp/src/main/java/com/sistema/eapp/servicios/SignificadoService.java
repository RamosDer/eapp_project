/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.servicios;

import com.sistema.eapp.modelo.Significado;
import java.util.List;
import java.util.Optional;

public interface SignificadoService {

     Significado guardarSignificado(Significado significado);
    
    Optional<Significado> obtenerPorId(Long id);

    List<Significado> listarTodos();

    void eliminarSignificado(Long id);

}
