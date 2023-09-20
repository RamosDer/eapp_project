/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.servicios.impl;

import com.sistema.eapp.modelo.Significado;
import com.sistema.eapp.repositorios.SignificadoRepository;
import com.sistema.eapp.servicios.SignificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SignificadoServiceImpl implements SignificadoService {

    @Autowired
    private SignificadoRepository significadoRepository;

    @Override
    public Significado guardarSignificado(Significado significado) {
        return significadoRepository.save(significado);
    }

    @Override
    public Optional<Significado> obtenerPorId(Long id) {
        return significadoRepository.findById(id);
    }

    @Override
    public List<Significado> listarTodos() {
        return significadoRepository.findAll();
    }

    @Override
    public void eliminarSignificado(Long id) {
        significadoRepository.deleteById(id);
    }
}
