package com.sistema.eapp.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "practica")
public class Practica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_practica")
    private Integer idPractica;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_palabra_frase")
    private PalabraFrase palabraFrase;

    @ManyToOne
    @JoinColumn(name = "id_oracion")
    private Oracion oracion;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

    @Column(name = "fecha_practica", nullable = false)
    private LocalDateTime fechaPractica;

    @Column(name = "acierto", nullable = false)
    private Boolean acierto;

    // Getters, Setters y demás.

    public Integer getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(Integer idPractica) {
        this.idPractica = idPractica;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PalabraFrase getPalabraFrase() {
        return palabraFrase;
    }

    public void setPalabraFrase(PalabraFrase palabraFrase) {
        this.palabraFrase = palabraFrase;
    }

    public Oracion getOracion() {
        return oracion;
    }

    public void setOracion(Oracion oracion) {
        this.oracion = oracion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaPractica() {
        return fechaPractica;
    }

    public void setFechaPractica(LocalDateTime fechaPractica) {
        this.fechaPractica = fechaPractica;
    }

    public Boolean getAcierto() {
        return acierto;
    }

    public void setAcierto(Boolean acierto) {
        this.acierto = acierto;
    }
}
