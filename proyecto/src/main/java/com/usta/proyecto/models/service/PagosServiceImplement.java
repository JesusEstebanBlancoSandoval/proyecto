package com.usta.proyecto.models.service;

import com.usta.proyecto.dao.PagosDAO;
import com.usta.proyecto.entities.PagosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagosServiceImplement  implements  IPagosService{
    @Autowired
    private PagosDAO PagosDAO;


    @Override
    @Transactional(readOnly = true)
    public List<PagosEntity> findAll(){
        return (List<PagosEntity>) PagosDAO.findAll();
    }


    @Override
    @Transactional
    public void save(PagosEntity detalles){
        PagosDAO.save(detalles);

    }


    @Override
    @Transactional
    public void remove(Long id){
        PagosDAO.deleteById(id);
    }

    @Override
    @Transactional
    public PagosEntity updatePagos(PagosEntity detalles){
        return PagosDAO.save(detalles);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        PagosDAO.changeState(id);
    }
    @Override
    @Transactional(readOnly = true)
    public PagosEntity findOne(Long id){
        return PagosDAO.findById(id).orElse(null);
    }

}
