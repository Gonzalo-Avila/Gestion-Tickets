package com.vaixapp.model;

import com.vaixapp.model.enums.TipoUsuario;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Column(name = "usuario_id")
    @GeneratedValue
    @Id
    Long id;

    @Column(name = "usuario_username")
    String username;

    @Column(name = "usuario_password")
    String password;

    @Column(name = "usuario_nombre")
    String nombre;

    @Column(name = "usuario_apellido")
    String apellido;

    @Column(name = "usuario_email")
    String email;

    @Column(name = "usuario_telefono")
    String telefono;

    @Column(name = "usuario_rol")
    TipoUsuario rol;

    @Column(name = "usuario_fecha_alta")
    LocalDateTime fechaAlta;

    @ElementCollection
    @CollectionTable(name = "notificaciones",
            joinColumns=@JoinColumn(name = "notificacion_usuario"))
    List<Notificacion> notificaciones = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getRol() {
        return rol;
    }

    public void setRol(TipoUsuario rol) {
        this.rol = rol;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
