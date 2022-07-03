package com.mbravov.cambioapp.service.dto;

import lombok.Data;

@Data
public class ConversionDTO {
    private TipoCambioDTO tipoCambioDTO;
    private float montoConvertido;
}
