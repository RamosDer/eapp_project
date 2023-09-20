package com.sistema.eapp.servicios;

import com.sistema.eapp.modelo.Usuario;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}
