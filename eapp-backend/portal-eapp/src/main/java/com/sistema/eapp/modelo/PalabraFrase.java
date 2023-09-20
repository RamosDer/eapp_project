package com.sistema.eapp.modelo;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "palabra_frase")
public class PalabraFrase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "palabra_frase_id_palabra_frase_seq_2")
    @SequenceGenerator(name = "palabra_frase_id_palabra_frase_seq_2", sequenceName = "public.palabra_frase_id_palabra_frase_seq_2", allocationSize = 1)
    private Integer idPalabraFrase;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "dificultad", nullable = false, length = 10)
    private String dificultad;

    @Column(name = "aprendido", nullable = false)
    private Boolean aprendido;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipo tipo;

    // Getter, setters, etc.

    public Integer getIdPalabraFrase() {
        return idPalabraFrase;
    }

    public void setIdPalabraFrase(Integer idPalabraFrase) {
        this.idPalabraFrase = idPalabraFrase;
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
