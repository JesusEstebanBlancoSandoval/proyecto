package com.usta.proyecto.dao;

import com.usta.proyecto.entities.EmpresasEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmpresasDAO extends CrudRepository<EmpresasEntity, Long> {
     public void changeState(Long id);
}
