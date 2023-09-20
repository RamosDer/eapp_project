/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.eapp.modelo;

/**
 *
 * @author Derlis Ramos
 */

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "significado")
public class Significado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "significado_seq_gen")
    @SequenceGenerator(name = "significado_seq_gen", sequenceName = "public.significado_id_significado_seq", allocationSize = 1)
    @Column(name = "id_significado")
    private Integer idSignificado;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_palabra_frase", nullable = false)
    private PalabraFrase palabraFrase;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    // Getter y Setter para idSignificado
    public Integer getIdSignificado() {
        return idSignificado;
    }

    public void setIdSignificado(Integer idSignificado) {
        this.idSignificado = idSignificado;
    }

    // Getter y Setter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter y Setter para palabraFrase
    public PalabraFrase getPalabraFrase() {
        return palabraFrase;
    }

    public void setPalabraFrase(PalabraFrase palabraFrase) {
        this.palabraFrase = palabraFrase;
    }

    // Getter y Setter para fechaRegistro
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    // Puedes agregar más métodos útiles como toString(), equals(), hashCode() si lo consideras necesario.
}
