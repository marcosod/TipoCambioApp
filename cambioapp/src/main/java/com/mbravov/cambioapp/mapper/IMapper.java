package com.mbravov.cambioapp.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
