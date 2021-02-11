package com.vaixapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Embeddable
public class ComentarioCaso {

    @ManyToOne
    @JoinColumn(name = "comentario_usuario")
    Usuario usuario;

    @Column(name = "comentario_fecha")
    LocalDateTime fecha;

    @Column(name = "comentario_cuerpo")
    String cuerpo;
}
