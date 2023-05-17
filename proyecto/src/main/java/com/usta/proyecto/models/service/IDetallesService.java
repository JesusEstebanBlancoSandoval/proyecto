package com.usta.proyecto.models.service;

import com.usta.proyecto.entities.DetallesEntity;
import com.usta.proyecto.entities.PagosEntity;

import java.util.List;

public interface IDetallesService {
    public List<DetallesEntity> findAll();

    public void save(DetallesEntity detalles);

    public void remove(Long id);

    public DetallesEntity updateDetalles(DetallesEntity detalles);
    
    public void changeState(Long id);

    public DetallesEntity findOne(Long id);
}
