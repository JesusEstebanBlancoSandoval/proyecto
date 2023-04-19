package com.usta.proyecto.service;

import com.usta.proyecto.dao.CiudadDAO;
import com.usta.proyecto.dao.EmpresasDAO;
import com.usta.proyecto.entities.CiudadEntity;
import com.usta.proyecto.entities.EmpresasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CiudadServiceImplement implements ICiudadService{
    @Autowired
    private CiudadDAO CiudadDAO;


    @Override
    @Transactional(readOnly = true)
    public List<CiudadEntity> findAll(){
        return (List<CiudadEntity>) CiudadDAO.findAll();
    }


    @Override
    @Transactional
    public void save(CiudadEntity telefono){
        CiudadDAO.save(telefono);

    }


    @Override
    @Transactional
    public void remove(Long id){
        CiudadDAO.deleteById(id);
    }

    @Override
    @Transactional
    public CiudadEntity updateCiudad(CiudadEntity telefono){
        return CiudadDAO.save(telefono);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        CiudadDAO.changeState(id);
    }
    @Override
    @Transactional(readOnly = true)
    public CiudadEntity findOne(Long id){
        return CiudadDAO.findById(id).orElse(null);
    }
}
