package com.mbravov.cambioapp.controller;

import com.mbravov.cambioapp.excepciones.TipoCambioExceptions;
import com.mbravov.cambioapp.persistence.entity.TipoCambio;
import com.mbravov.cambioapp.service.TipoCambioService;
import com.mbravov.cambioapp.service.dto.ConversionDTO;
import com.mbravov.cambioapp.service.dto.TipoCambioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/tipoCambio")
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;

    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @PostMapping("create")
    public TipoCambio createTipoCambio(@RequestBody TipoCambioDTO tipoCambioDTO){
        return this.tipoCambioService.createTipoCambio(tipoCambioDTO);
    }

    @GetMapping("/findById/{id}")
    public Optional<TipoCambio> findById(@PathVariable("id") Long id){
        return this.tipoCambioService.findById(id);
    }

    @GetMapping("/findAll")
    public List<TipoCambio> findAll(){
        return this.tipoCambioService.findAll();
    }

    @GetMapping("/findByMonedaOrigen/{monedaorigen}")
    public List<TipoCambio> findByMonedaOrigen(@PathVariable("monedaorigen") String monedaorigen){
        return this.tipoCambioService.findByMonedaOrigen(monedaorigen);
    }

    @GetMapping("/findByMonedaDestino/{monedadestino}")
    public List<TipoCambio> findByMonedaDestino(@PathVariable("monedadestino") String monedadestino){
        return this.tipoCambioService.findByMonedaDestino(monedadestino);
    }

    @PutMapping("updateFindId/{id}")
    public ResponseEntity updateFindId(@PathVariable("id") Long id, @RequestBody TipoCambioDTO tipoCambioDTO){
          this.tipoCambioService.updateTipoCambioById(id,tipoCambioDTO);
          return ResponseEntity.noContent().build();
    }

    @GetMapping("conversion/{idTipoCambio}/{montoAconvertir}")
    public ConversionDTO conversion(@PathVariable("idTipoCambio") long idTipoCambio, @PathVariable("montoAconvertir") float montoAconvertir){
        return this.tipoCambioService.conversion(idTipoCambio,montoAconvertir);
    }
}
