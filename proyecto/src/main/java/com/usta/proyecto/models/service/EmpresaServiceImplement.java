package com.usta.proyecto.models.service;


import com.usta.proyecto.dao.EmpresasDAO;
import com.usta.proyecto.entities.EmpresasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaServiceImplement implements  IEmpresasService{
    @Autowired
    private EmpresasDAO EmpresasDAO;


    @Override
    @Transactional(readOnly = true)
    public List<EmpresasEntity> findAll(){
        return (List<EmpresasEntity>) EmpresasDAO.findAll();
    }


    @Override
    @Transactional
    public void save(EmpresasEntity telefono){
        EmpresasDAO.save(telefono);

    }


    @Override
    @Transactional
    public void remove(Long id){
        EmpresasDAO.deleteById(id);
    }

    @Override
    @Transactional
    public EmpresasEntity updateEmpresas(EmpresasEntity telefono){
        return EmpresasDAO.save(telefono);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        EmpresasDAO.changeState(id);
    }
    @Override
    @Transactional(readOnly = true)
    public EmpresasEntity findOne(Long id){
        return EmpresasDAO.findById(id).orElse(null);
    }


}
