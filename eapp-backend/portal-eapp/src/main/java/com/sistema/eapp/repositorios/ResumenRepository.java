package com.sistema.eapp.repositorios;

import com.sistema.eapp.modelo.Resumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumenRepository extends JpaRepository<Resumen, Long> {
    
}
