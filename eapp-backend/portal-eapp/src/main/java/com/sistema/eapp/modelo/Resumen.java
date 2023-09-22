package com.sistema.eapp.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resumen")
public class Resumen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resumen_id_resumen_seq")
    @SequenceGenerator(name = "resumen_id_resumen_seq", sequenceName = "public.resumen_id_resumen_seq", allocationSize = 1)
    private Long idResumen;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_practica", nullable = false)
    private Practica practica;

    // Getters, Setters, etc.

    public Long getIdResumen() {
        return idResumen;
    }

    public void setIdResumen(Long idResumen) {
        this.idResumen = idResumen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }
}
