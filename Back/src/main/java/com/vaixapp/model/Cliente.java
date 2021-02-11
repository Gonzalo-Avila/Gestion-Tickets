package com.vaixapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Column(name = "cliente_id")
    @GeneratedValue
    @Id
    Long id;

    @Column(name = "cliente_razon_social")
    String razonSocial;

    @Column(name = "cliente_direccion")
    String direccion;

    @ManyToOne
    @JoinColumn(name = "cliente_encargado")
    Contacto encargado;

    @ManyToMany
    @JoinTable(name = "contactoXcliente",
            joinColumns=
            @JoinColumn(name="cliente_id", referencedColumnName="cliente_id"),
            inverseJoinColumns=
            @JoinColumn(name="contacto_id", referencedColumnName="contacto_id")
    )
    List<Contacto> contactos = new ArrayList<>();

    @Column(name = "cliente_informacion")
    String informacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Contacto getEncargado() {
        return encargado;
    }

    public void setEncargado(Contacto encargado) {
        this.encargado = encargado;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
