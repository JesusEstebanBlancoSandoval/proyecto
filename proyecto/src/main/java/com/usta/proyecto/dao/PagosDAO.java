package com.usta.proyecto.dao;

import com.usta.proyecto.entities.PagosEntity;
import org.springframework.data.repository.CrudRepository;

public interface PagosDAO extends CrudRepository<PagosEntity,Long> {
    public void changeState(Long id);


}
