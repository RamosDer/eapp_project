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

    @Column(name = "texto", nullable = false)
    private String contenido;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_palabra_frase", nullable = false)
    private PalabraFrase palabraFrase;

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

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setPalabraFrase(PalabraFrase palabraFrase) {
        this.palabraFrase = palabraFrase;
    }

    public PalabraFrase getPalabraFrase() {
        return palabraFrase;
    }
}
