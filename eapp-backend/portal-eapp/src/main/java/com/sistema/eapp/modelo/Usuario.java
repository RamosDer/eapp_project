package com.sistema.eapp.modelo;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;  
    
    private String nombre;
    private String apellido;

    @Column(name = "contrasenha")  
    private String contrasenha; 

    @CreationTimestamp
    @Column(name = "fecha_registro")
    private LocalDateTime fecha_registro;
    private String perfil;


    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, String nombre, String apellido, String contrasenha, LocalDateTime fecha_registro) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenha = contrasenha;
        this.fecha_registro = fecha_registro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Como hemos eliminado UsuarioRol y Rol, deberías decidir cómo administrar las autoridades aquí
        return null;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getFechaRegistro(){
        return fecha_registro;
    }

    public void setFechaRegistro(LocalDateTime fecha_registro){
        this.fecha_registro = fecha_registro;
    }


    // Si queremos mantener algún tipo de autoridad o roles en el futuro, 
    // hay que modificar el método getAuthorities y posiblemente agregar 
    // otros campos o relaciones para manejar esto.

    @Override
    public String getPassword() {
        return this.contrasenha;
    }

    @Override
    public String getUsername() {
        return this.nombreUsuario;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
