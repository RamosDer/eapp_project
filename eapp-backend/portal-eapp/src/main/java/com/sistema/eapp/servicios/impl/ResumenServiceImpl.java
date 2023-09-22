package com.sistema.eapp.servicios.impl;

import com.sistema.eapp.modelo.Resumen;
import com.sistema.eapp.repositorios.ResumenRepository;
import com.sistema.eapp.servicios.ResumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumenServiceImpl implements ResumenService {

    @Autowired
    private ResumenRepository resumenRepository;

    @Override
    public Resumen guardarResumen(Resumen resumen) {
        return resumenRepository.save(resumen);
    }

    @Override
    public Optional<Resumen> obtenerResumenPorId(Long id) {
        return resumenRepository.findById(id);
    }

    @Override
    public List<Resumen> listarTodos() {
        return resumenRepository.findAll();
    }

    @Override
    public void eliminarResumen(Long id) {
        resumenRepository.deleteById(id);
    }

    //  más métodos relacionados con la entidad Resumen, puedes agregarlos aquí.

}
