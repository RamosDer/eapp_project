package com.sistema.eapp.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tipo")
public class Tipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_id_tipo_seq")
    @SequenceGenerator(name = "tipo_id_tipo_seq", sequenceName = "public.tipo_id_tipo_seq", allocationSize = 1)
    private Integer idTipo;

    @Column(name = "descripcion", nullable = false, length = 10)
    private String descripcion;

    @Column(name = "cod_tipo", nullable = false, length = 10)
    private String codTipo;

    @ManyToOne(fetch = FetchType.LAZY)  // La carga perezosa es comúnmente utilizada en relaciones ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

     // Constructor que toma la descripción como argumento
    public Tipo(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter, setters, hashCode, equals, toString, etc.
    

    // Opcional: Si necesitas la relación bidireccional, puedes añadir un conjunto de objetos "Tipo" en la clase "Categoria" y usar la anotación @OneToMany con "mappedBy".

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

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
}
