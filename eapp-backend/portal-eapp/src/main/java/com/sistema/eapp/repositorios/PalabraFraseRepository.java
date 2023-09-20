/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.repositorios;

import com.sistema.eapp.modelo.PalabraFrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalabraFraseRepository extends JpaRepository<PalabraFrase, Long> {

    // Al igual que en los otros casos, agrega aquí métodos adicionales de búsqueda si los necesitas.

}
