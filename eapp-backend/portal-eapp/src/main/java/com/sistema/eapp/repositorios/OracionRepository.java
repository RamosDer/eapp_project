package com.sistema.eapp.repositorios;

import com.sistema.eapp.modelo.Oracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracionRepository extends JpaRepository<Oracion, Long> {
    
    
}
