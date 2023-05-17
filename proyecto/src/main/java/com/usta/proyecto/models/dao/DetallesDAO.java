package com.usta.proyecto.models.dao;

import com.usta.proyecto.entities.DetallesEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DetallesDAO  extends CrudRepository<DetallesEntity,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE DetallesEntity SET estado = false WHERE id_detalles=?1")
    public void changeState(Long id);
}
