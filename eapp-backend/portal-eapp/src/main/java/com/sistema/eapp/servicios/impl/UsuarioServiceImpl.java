package com.sistema.eapp.servicios.impl;

import com.sistema.eapp.modelo.Usuario;
import com.sistema.eapp.repositorios.UsuarioRepository;
import com.sistema.eapp.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByNombreUsuario(usuario.getNombreUsuario());
        if (usuarioLocal != null) {
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        } else {
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

}
