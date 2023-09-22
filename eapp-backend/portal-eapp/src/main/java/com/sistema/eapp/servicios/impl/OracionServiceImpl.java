package com.sistema.eapp.servicios.impl;

import com.sistema.eapp.modelo.Oracion;
import com.sistema.eapp.repositorios.OracionRepository;
import com.sistema.eapp.servicios.OracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OracionServiceImpl implements OracionService {

    @Autowired
    private OracionRepository oracionRepository;

    @Override
    public Oracion guardarOracion(Oracion oracion) {
        return oracionRepository.save(oracion);
    }

    @Override
    public Optional<Oracion> obtenerPorId(Long id) {
        return oracionRepository.findById(id);
    }

    @Override
    public List<Oracion> listarTodos() {
        return oracionRepository.findAll();
    }

    @Override
    public void eliminarOracion(Long id) {
        oracionRepository.deleteById(id);
    }
}
