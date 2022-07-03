package com.mbravov.cambioapp.service.dto;

import lombok.Data;

@Data
public class TipoCambioDTO {
    private String moneda_origen;
    private String moneda_destino;
    private float monto;
    private String descripcion;
}
