package com.sistema.eapp.repositorios;

import com.sistema.eapp.modelo.Practica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticaRepository extends JpaRepository<Practica, Long> {
    
    
}
