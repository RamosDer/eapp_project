/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.servicios;

import com.sistema.eapp.modelo.Tipo;
import java.util.List;
import java.util.Optional;

public interface TipoService {

    Tipo guardarTipo(Tipo tipo);

    Optional<Tipo> obtenerPorCodTipo(String codTipo);

    List<Tipo> listarTodos();

    void eliminarTipo(String codTipo);

}
