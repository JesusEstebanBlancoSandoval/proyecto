package com.usta.proyecto.service;

import com.usta.proyecto.dao.PersonasDAO;
import com.usta.proyecto.dao.TelefonoDAO;
import com.usta.proyecto.entities.PersonasEntity;
import com.usta.proyecto.entities.TelefonoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonasServiceImplement implements IPersonasService{
    @Autowired
    private PersonasDAO PersonasDAO;


    @Override
    @Transactional(readOnly = true)
    public List<PersonasEntity> findAll(){
        return (List<PersonasEntity>) PersonasDAO.findAll();
    }


    @Override
    @Transactional
    public void save(PersonasEntity personas){
        PersonasDAO.save(personas);

    }


    @Override
    @Transactional
    public void remove(Long id){
        PersonasDAO.deleteById(id);
    }

    @Override
    @Transactional
    public PersonasEntity updatePersonas(PersonasEntity personas){
        return PersonasDAO.save(personas);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        PersonasDAO.changeState(id);
    }
    @Override
    @Transactional(readOnly = true)
    public PersonasEntity findOne(Long id){
        return PersonasDAO.findById(id).orElse(null);
    }

}
