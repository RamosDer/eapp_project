package com.sistema.eapp.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "tipo")
public class Tipo implements Serializable {

    @Id
    @Column(name = "cod_tipo", nullable = false, length = 10)
    private String codTipo;

    @Column(name = "descripcion", nullable = false, length = 10)
    private String descripcion;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne(fetch = FetchType.EAGER)  
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

     // Constructor que toma la descripción como argumento
    public Tipo(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo() {}

    // Getter, setters, hashCode, equals, toString, etc.
    

    // Opcional: Si necesitas la relación bidireccional, puedes añadir un conjunto de objetos "Tipo" en la clase "Categoria" y usar la anotación @OneToMany con "mappedBy".

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
