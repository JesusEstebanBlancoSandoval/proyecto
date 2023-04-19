package com.usta.proyecto.dao;

import com.usta.proyecto.entities.DetallesEntity;
import org.springframework.data.repository.CrudRepository;

public interface DetallesDAO  extends CrudRepository<DetallesEntity,Long> {
    public void changeState(Long id);
}
