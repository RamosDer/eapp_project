package com.sistema.eapp.servicios;

import com.sistema.eapp.modelo.Practica;

import java.util.List;
import java.util.Optional;

public interface PracticaService {
    
    Practica guardarPractica(Practica practica);

    Optional<Practica> obtenerPracticaPorId(Long id);

    List<Practica> listarTodas();

    void eliminarPractica(Long id);
    
}
