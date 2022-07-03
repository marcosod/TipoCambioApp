package com.mbravov.cambioapp.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "TipoCambio")
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String moneda_origen;
    private String moneda_destino;
    private Float monto;
    private String descripcion;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_modificacion;
}

