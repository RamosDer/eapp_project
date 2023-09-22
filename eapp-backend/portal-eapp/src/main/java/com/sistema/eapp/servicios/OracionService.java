package com.sistema.eapp.servicios;

import com.sistema.eapp.modelo.Oracion;
import java.util.List;
import java.util.Optional;

public interface OracionService {

    Oracion guardarOracion(Oracion oracion);

    Optional<Oracion> obtenerPorId(Long id);

    List<Oracion> listarTodos();

    void eliminarOracion(Long id);
}
