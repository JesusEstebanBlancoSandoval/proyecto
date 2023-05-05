package com.usta.proyecto.models.service;

import com.usta.proyecto.entities.PagosEntity;
import com.usta.proyecto.entities.PersonasEntity;

import java.util.List;

public interface IPagosService {
    public List<PagosEntity> findAll();

    public void save(PagosEntity pagos);

    public void remove(Long id);

    public PagosEntity updatePagos(PagosEntity pagos);


    public void changeState(Long id);

    public PagosEntity findOne(Long id);
}
