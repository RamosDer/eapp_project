/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Derlis Ramos
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_id_categoria_seq_1")
    @SequenceGenerator(name = "categoria_id_categoria_seq_1", sequenceName = "public.categoria_id_categoria_seq_1", allocationSize = 1)
    private Long idCategoria;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    // Getter, setters, etc.

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
