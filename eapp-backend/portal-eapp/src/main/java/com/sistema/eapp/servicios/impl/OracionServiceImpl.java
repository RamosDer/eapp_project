package com.sistema.eapp.servicios.impl;

import com.sistema.eapp.modelo.Oracion;
import com.sistema.eapp.modelo.Tipo;
import com.sistema.eapp.repositorios.OracionRepository;
import com.sistema.eapp.repositorios.TipoRepository;
import com.sistema.eapp.servicios.OracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OracionServiceImpl implements OracionService {

    @Autowired
    private OracionRepository oracionRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public Oracion guardarOracion(Oracion oracion) {
        String descripcionTipo = oracion.getTipo().getDescripcion();
        List<Tipo> tiposExistente = tipoRepository.findByDescripcion(descripcionTipo);

        if (!tiposExistente.isEmpty()) {
            oracion.setTipo(tiposExistente.get(0));
        } else {
            Tipo nuevoTipo = new Tipo(descripcionTipo);
            nuevoTipo = tipoRepository.save(nuevoTipo);
            oracion.setTipo(nuevoTipo);
        }

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
