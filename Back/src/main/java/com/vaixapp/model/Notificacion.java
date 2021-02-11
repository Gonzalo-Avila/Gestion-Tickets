package com.vaixapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Notificacion {

    @Column(name = "notificacion_fecha")
    LocalDateTime fecha;

    @Column(name = "notificacion_cuerpo")
    String cuerpo;
}
