package com.vaixapp.model;

import javax.persistence.*;

@Entity
@Table(name = "contactos")
public class Contacto {

    @Column(name = "contacto_id")
    @GeneratedValue
    @Id
    Long id;

    @Column(name = "contacto_nombre")
    String nombre;

    @Column(name = "contacto_apellido")
    String apellido;

    @Column(name = "contacto_email")
    String email;

    @Column(name = "contacto_telefono")
    String telefono;

    @Column(name = "contacto_informacion")
    String informacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
