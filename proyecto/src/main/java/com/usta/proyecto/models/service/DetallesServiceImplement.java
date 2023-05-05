package com.usta.proyecto.models.service;


import com.usta.proyecto.dao.DetallesDAO;
import com.usta.proyecto.entities.DetallesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetallesServiceImplement implements IDetallesService{
    @Autowired
    private DetallesDAO DetallesDAO;


    @Override
    @Transactional(readOnly = true)
    public List<DetallesEntity> findAll(){
        return (List<DetallesEntity>) DetallesDAO.findAll();
    }


    @Override
    @Transactional
    public void save(DetallesEntity detalles){
        DetallesDAO.save(detalles);

    }


    @Override
    @Transactional
    public void remove(Long id){
        DetallesDAO.deleteById(id);
    }

    @Override
    @Transactional
    public DetallesEntity updateDetalles(DetallesEntity detalles){
        return DetallesDAO.save(detalles);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        DetallesDAO.changeState(id);
    }
    @Override
    @Transactional(readOnly = true)
    public DetallesEntity findOne(Long id){
        return DetallesDAO.findById(id).orElse(null);
    }
}
