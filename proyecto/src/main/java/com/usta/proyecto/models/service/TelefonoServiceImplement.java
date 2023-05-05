package com.usta.proyecto.models.service;

import com.usta.proyecto.dao.TelefonoDAO;
import com.usta.proyecto.entities.TelefonoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TelefonoServiceImplement implements ITelefonoService {
    @Autowired
    private TelefonoDAO TelefonoDao;


    @Override
    @Transactional(readOnly = true)
    public List<TelefonoEntity> findAll(){
        return (List<TelefonoEntity>) TelefonoDao.findAll();
    }


    @Override
    @Transactional
    public void save(TelefonoEntity telefono){
        TelefonoDao.save(telefono);

    }


    @Override
    @Transactional
    public void remove(Long id){
        TelefonoDao.deleteById(id);
    }

    @Override
    @Transactional
    public TelefonoEntity updateTelefono(TelefonoEntity telefono){
        return TelefonoDao.save(telefono);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        TelefonoDao.changeState(id);
    }
    @Override
    @Transactional(readOnly = true)
    public TelefonoEntity findOne(Long id){
        return TelefonoDao.findById(id).orElse(null);
    }

}
