package com.sistema.eapp.servicios;

import com.sistema.eapp.modelo.Resumen;

import java.util.List;
import java.util.Optional;

public interface ResumenService {

    Resumen guardarResumen(Resumen resumen);

    Optional<Resumen> obtenerResumenPorId(Long id);

    List<Resumen> listarTodos();

    void eliminarResumen(Long id);

    //  declarar más métodos relacionados con la entidad Resumen, puedes agregarlos aquí.
}
