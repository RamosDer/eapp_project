package com.sistema.eapp.servicios.impl;

import com.sistema.eapp.modelo.Practica;
import com.sistema.eapp.repositorios.PracticaRepository;
import com.sistema.eapp.servicios.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticaServiceImpl implements PracticaService {

    @Autowired
    private PracticaRepository practicaRepository;

    @Override
    public Practica guardarPractica(Practica practica) {
        return practicaRepository.save(practica);
    }

    @Override
    public Optional<Practica> obtenerPracticaPorId(Long id) {
        return practicaRepository.findById(id);
    }

    @Override
    public List<Practica> listarTodas() {
        return practicaRepository.findAll();
    }

    @Override
    public void eliminarPractica(Long id) {
        practicaRepository.deleteById(id);
    }
    
}
