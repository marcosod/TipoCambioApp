package com.mbravov.cambioapp.persistence.repository;

import com.mbravov.cambioapp.persistence.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {

    @Query(nativeQuery = false,value = " SELECT p FROM TipoCambio p WHERE moneda_origen=:moneda_origen ")
    public List<TipoCambio> findByMonedaOrigen(String moneda_origen);

    @Query(nativeQuery = false,value = " SELECT p FROM TipoCambio p WHERE moneda_destino=:moneda_destino ")
    public List<TipoCambio> findByMonedaDestino(String moneda_destino);
}
