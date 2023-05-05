package com.usta.proyecto.dao;

import com.usta.proyecto.entities.RegistrosEntity;
import com.usta.proyecto.entities.TelefonoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TelefonoDAO extends CrudRepository<TelefonoEntity,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE TelefonoEntity SET Estado = false WHERE idTelefono =?1")
    public void changeState(Long id);


}
