package com.usta.proyecto.models.dao;

import com.usta.proyecto.entities.PagosEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PagosDAO extends CrudRepository<PagosEntity,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE PagosEntity SET estado = false WHERE id_pago=?1")
    public void changeState(Long id);


}
