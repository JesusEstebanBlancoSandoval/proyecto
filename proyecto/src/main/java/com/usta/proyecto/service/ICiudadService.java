package com.usta.proyecto.service;

import com.usta.proyecto.entities.CiudadEntity;
import com.usta.proyecto.entities.PagosEntity;

import java.util.List;

public interface ICiudadService {
    public List<CiudadEntity> findAll();

    public void save(CiudadEntity ciudad);

    public void remove(Long id);

    public CiudadEntity updateCiudad(CiudadEntity ciudad);


    public void changeState(Long id);

    public CiudadEntity findOne(Long id);
}
