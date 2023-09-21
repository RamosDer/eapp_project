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
    public Optional<Tipo> obtenerPorCodTipo(String codTipo) {
        return tipoRepository.findById(codTipo); // Cambiado de findByCodTipo a findById
    }

    @Override
    public List<Tipo> listarTodos() {
        return tipoRepository.findAll();
    }

    @Override
    public void eliminarTipo(String codTipo) {
        tipoRepository.deleteById(codTipo); // Cambiado de Long id a String codTipo
    }
}
