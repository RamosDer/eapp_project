/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.servicios.impl;

import com.sistema.eapp.modelo.PalabraFrase;
import com.sistema.eapp.repositorios.PalabraFraseRepository;
import com.sistema.eapp.servicios.PalabraFraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PalabraFraseServiceImpl implements PalabraFraseService {

    @Autowired
    private PalabraFraseRepository palabraFraseRepository;

    @Override
    public PalabraFrase guardarPalabraFrase(PalabraFrase palabraFrase) {
        return palabraFraseRepository.save(palabraFrase);
    }

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
}
