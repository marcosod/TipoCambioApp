package com.mbravov.cambioapp.mapper;

import com.mbravov.cambioapp.persistence.entity.TipoCambio;
import com.mbravov.cambioapp.service.dto.TipoCambioDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class TaskDTOtoTask implements  IMapper<TipoCambioDTO, TipoCambio>{
    @Override
    public TipoCambio map(TipoCambioDTO in) {
        TipoCambio tipoCambio = new TipoCambio();
        tipoCambio.setMoneda_origen(in.getMoneda_origen());
        tipoCambio.setMoneda_destino(in.getMoneda_destino());
        tipoCambio.setDescripcion(in.getDescripcion());
        tipoCambio.setFecha_creacion(LocalDateTime.now());
        tipoCambio.setMonto(in.getMonto());
        return tipoCambio;
    }

}
