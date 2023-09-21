/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.repositorios;

import com.sistema.eapp.modelo.Tipo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, String> {

    List<Tipo> findByDescripcion(String descripcion);


    // Si necesitas encontrar un Tipo específico por alguna propiedad, simplemente declara un método aquí, similar al findByNombreUsuario en el ejemplo.

}
