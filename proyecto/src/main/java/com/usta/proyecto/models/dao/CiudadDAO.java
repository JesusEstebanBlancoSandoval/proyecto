package com.usta.proyecto.models.dao;

import com.usta.proyecto.entities.CiudadEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CiudadDAO extends CrudRepository<CiudadEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE CiudadEntity SET estado = false WHERE idCiudades=?1")
    public void changeState(Long id);
}
