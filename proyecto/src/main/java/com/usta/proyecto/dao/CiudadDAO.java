package com.usta.proyecto.dao;

import com.usta.proyecto.entities.CiudadEntity;
import org.springframework.data.repository.CrudRepository;

public interface CiudadDAO extends CrudRepository<CiudadEntity, Long> {
    public void changeState(Long id);
}
