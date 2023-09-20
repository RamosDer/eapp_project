/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.servicios.impl;

import com.sistema.eapp.modelo.PalabraFrase;
import com.sistema.eapp.modelo.Tipo;
import com.sistema.eapp.repositorios.PalabraFraseRepository;
import com.sistema.eapp.repositorios.TipoRepository;
import com.sistema.eapp.servicios.PalabraFraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PalabraFraseServiceImpl implements PalabraFraseService {

    @Autowired
    private PalabraFraseRepository palabraFraseRepository;

    @Autowired
    private TipoRepository tipoRepository;


    @Override
    public Optional<PalabraFrase> obtenerPalabraFraseById(Long id) {
        return palabraFraseRepository.findById(id);
    }

    @Override
    public List<PalabraFrase> listarTodos() {
        return palabraFraseRepository.findAll();
    }

    @Override
    public void eliminarPalabraFrase(Long id) {
        palabraFraseRepository.deleteById(id);
    }
    @Override
    public PalabraFrase guardarPalabraFrase(PalabraFrase palabraFrase) {
        String descripcionTipo = palabraFrase.getTipo().getDescripcion();
        List<Tipo> tiposExistente = tipoRepository.findByDescripcion(descripcionTipo);

        if (!tiposExistente.isEmpty()) {
            // Si ya existe un Tipo con esa descripción, asigna el primero (o el que desees) a la PalabraFrase.
            palabraFrase.setTipo(tiposExistente.get(0));
        } else {
            Tipo nuevoTipo = new Tipo(descripcionTipo);
            // Guarda el nuevo Tipo en la base de datos antes de asignarlo a la PalabraFrase.
            nuevoTipo = tipoRepository.save(nuevoTipo);
            palabraFrase.setTipo(nuevoTipo);
        }

        return palabraFraseRepository.save(palabraFrase);
    }
}
