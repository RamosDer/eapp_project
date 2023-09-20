package com.sistema.eapp.repositorios;

import com.sistema.eapp.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByNombreUsuario(String nombreUsuario);

}
