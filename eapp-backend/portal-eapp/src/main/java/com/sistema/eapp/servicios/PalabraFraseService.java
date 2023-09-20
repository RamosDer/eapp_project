/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.servicios;

import com.sistema.eapp.modelo.PalabraFrase;
import java.util.List;
import java.util.Optional;

public interface PalabraFraseService {

    PalabraFrase guardarPalabraFrase(PalabraFrase palabraFrase);

    Optional<PalabraFrase> obtenerPalabraFraseById(Long id);

    List<PalabraFrase> listarTodos();

    void eliminarPalabraFrase(Long id);

}
