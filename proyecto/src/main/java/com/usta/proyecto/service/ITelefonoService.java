package com.usta.proyecto.service;

import com.usta.proyecto.entities.TelefonoEntity;

import java.util.List;

public interface ITelefonoService {

    public List<TelefonoEntity> findAll();

    public void save(TelefonoEntity telefono);

    public void remove(Long id);

    public TelefonoEntity updateTelefono(TelefonoEntity telefono);


    public void changeState(Long id);

    public TelefonoEntity findOne(Long id);


}
