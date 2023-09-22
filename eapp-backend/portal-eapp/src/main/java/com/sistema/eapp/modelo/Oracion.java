package com.sistema.eapp.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "oracion")
public class Oracion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oracion_id_oracion_seq")
    @SequenceGenerator(name = "oracion_id_oracion_seq", sequenceName = "public.oracion_id_oracion_seq", allocationSize = 1)
    private Long idOracion;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "dificultad", nullable = false, length = 10)
    private String dificultad;

    @Column(name = "aprendido", nullable = false)
    private Boolean aprendido;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "cod_tipo", nullable = false)
    private Tipo tipo;

    // Getter, setters, etc.

    public Long getIdOracion() {
        return idOracion;
    }

    public void setIdOracion(Long idOracion) {
        this.idOracion = idOracion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Boolean getAprendido() {
        return aprendido;
    }

    public void setAprendido(Boolean aprendido) {
        this.aprendido = aprendido;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
