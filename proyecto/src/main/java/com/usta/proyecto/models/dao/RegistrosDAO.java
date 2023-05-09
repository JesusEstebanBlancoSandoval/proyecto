package com.usta.proyecto.models.dao;

import com.usta.proyecto.entities.RegistrosEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RegistrosDAO extends CrudRepository<RegistrosEntity,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE RegistrosEntity SET Estado = false WHERE idPersona =?1")
    public void changeState(Long id);
}
