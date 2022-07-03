package com.mbravov.cambioapp.service;

import com.mbravov.cambioapp.excepciones.TipoCambioExceptions;
import com.mbravov.cambioapp.mapper.TaskDTOtoTask;
import com.mbravov.cambioapp.persistence.entity.TipoCambio;
import com.mbravov.cambioapp.persistence.repository.TipoCambioRepository;
import com.mbravov.cambioapp.service.dto.ConversionDTO;
import com.mbravov.cambioapp.service.dto.TipoCambioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCambioService {

    private final TipoCambioRepository repository;
    private final TaskDTOtoTask mapper;

    public TipoCambioService(TipoCambioRepository repository, TaskDTOtoTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TipoCambio createTipoCambio(TipoCambioDTO tipoCambioDTO){
        return this.repository.save(this.mapper.map(tipoCambioDTO));
    }

    public void updateTipoCambioById(Long id, TipoCambioDTO tipoCambioDTO){
        Optional<TipoCambio> getTipoCambio = this.findById(id);
        if(getTipoCambio.isEmpty()){
              throw  new TipoCambioExceptions("Código no encontrado" , HttpStatus.NOT_FOUND);
        }else{
            TipoCambio tipoCambio = new TipoCambio();
            tipoCambio.setId(id);
            tipoCambio.setMoneda_origen(tipoCambioDTO.getMoneda_origen());
            tipoCambio.setMoneda_destino(tipoCambioDTO.getMoneda_destino());
            tipoCambio.setDescripcion(tipoCambioDTO.getDescripcion());
            tipoCambio.setFecha_creacion(getTipoCambio.get().getFecha_creacion());
            tipoCambio.setFecha_modificacion(LocalDateTime.now());
            tipoCambio.setMonto(tipoCambioDTO.getMonto());
            this.repository.save(tipoCambio);
        }
    }
    public Optional<TipoCambio> findById (Long id){
        return this.repository.findById(id);
    }

    public List<TipoCambio> findAll (){
        return this.repository.findAll();
    }

    public List<TipoCambio> findByMonedaOrigen(String moneda_origen){
        return  this.repository.findByMonedaOrigen(moneda_origen);
    }

    public List<TipoCambio> findByMonedaDestino(String moneda_destino){
        return  this.repository.findByMonedaDestino(moneda_destino);
    }

    public ConversionDTO conversion( long id , float montoAconvertir){
        Optional<TipoCambio> getTipoCambio = this.findById(id);
        if(getTipoCambio.isEmpty()){
            throw  new TipoCambioExceptions("Código no encontrado" , HttpStatus.NOT_FOUND);
        }else{
            ConversionDTO conversion = new ConversionDTO();
            TipoCambioDTO tipoCambioDTO = new TipoCambioDTO();

            tipoCambioDTO.setMoneda_origen(getTipoCambio.get().getMoneda_origen());
            tipoCambioDTO.setMoneda_destino(getTipoCambio.get().getMoneda_destino());
            tipoCambioDTO.setDescripcion(getTipoCambio.get().getDescripcion());
            tipoCambioDTO.setMonto(getTipoCambio.get().getMonto());

            conversion.setTipoCambioDTO(tipoCambioDTO);
            conversion.setMontoConvertido((float) (getTipoCambio.get().getMonto() * montoAconvertir));
            return conversion;
        }
    }
}
