/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.servicios.impl;

import com.sistema.eapp.modelo.Tipo;
import com.sistema.eapp.repositorios.TipoRepository;
import com.sistema.eapp.servicios.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public Tipo guardarTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    public Optional<Tipo> obtenerPorId(Long id) {
        return tipoRepository.findById(id);
    }

    @Override
    public List<Tipo> listarTodos() {
        return tipoRepository.findAll();
    }

    @Override
    public void eliminarTipo(Long id) {
        tipoRepository.deleteById(id);
    }
}
