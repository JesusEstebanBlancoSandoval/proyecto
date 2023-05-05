package com.usta.proyecto.models.service;

import com.usta.proyecto.entities.EmpresasEntity;
import com.usta.proyecto.entities.PagosEntity;

import java.util.List;

public interface IEmpresasService {
    public List<EmpresasEntity> findAll();

    public void save(EmpresasEntity empresas);

    public void remove(Long id);

    public EmpresasEntity updateEmpresas(EmpresasEntity empresas);


    public void changeState(Long id);

    public EmpresasEntity findOne(Long id);
}
