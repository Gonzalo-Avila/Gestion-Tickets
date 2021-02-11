package com.vaixapp.model;

import com.vaixapp.model.enums.CategoriaCaso;
import com.vaixapp.model.enums.EstadoDeCaso;
import com.vaixapp.model.enums.PrioridadCaso;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "casos")
public class Caso {

    @Column(name = "caso_id")
    @GeneratedValue
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "caso_cliente")
    Cliente cliente;

    @Enumerated(EnumType.STRING)
    PrioridadCaso prioridad;

    @Enumerated(EnumType.STRING)
    CategoriaCaso categoria;

    @Column(name = "caso_titulo")
    String titulo;

    @Column(name = "caso_descripcion")
    String descripcion;

    @Column(name = "caso_resolucion")
    String resolucion;

    @ManyToOne
    @JoinColumn(name = "caso_tecnico_asignado")
    Usuario usuarioAsignado;

    @Enumerated(EnumType.STRING)
    @Column(name = "caso_estado")
    EstadoDeCaso estado;

    @Column(name = "caso_fecha_apertura")
    LocalDateTime fechaApertura;

    @Column(name = "caso_fecha_cierre")
    LocalDateTime fechaCierre;

    @ElementCollection
    @CollectionTable(name = "comentarios",
            joinColumns=@JoinColumn(name = "comentario_caso"))
    List<ComentarioCaso> comentarios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public Usuario getTecnicoAsignado() {
        return usuarioAsignado;
    }

    public void setTecnicoAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    public EstadoDeCaso getEstado() {
        return estado;
    }

    public void setEstado(EstadoDeCaso estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDateTime fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public PrioridadCaso getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadCaso prioridad) {
        this.prioridad = prioridad;
    }

    public CategoriaCaso getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCaso categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    public List<ComentarioCaso> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioCaso> comentarios) {
        this.comentarios = comentarios;
    }
}
