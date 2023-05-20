package com.usta.proyecto.controllers;

import com.usta.proyecto.entities.CiudadEntity;
import org.springframework.ui.Model;
import com.usta.proyecto.models.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class CiudadController {
    @Autowired
    private ICiudadService iCiudadService;


    @GetMapping("listarCiudades")
    public String listarUniversidades(Model model){
        model.addAttribute("ciudades",iCiudadService.findAll());
        model.addAttribute("titulos","Listado universidades");
        return "listarCiudades";

    }

    @GetMapping("crearCiudad")
    public String crearCiudad(Model model){
        model.addAttribute("titulo","crear Ciudad");
        model.addAttribute("Ciudad",new CiudadEntity());
       return "crearCiudad";
    }
    @GetMapping("gestorTablas/index")
    public String MostrarIndex(Model model){
        return "gestorTablas/index";

    }

    @PostMapping(value = "crearCiudad")
    public String guardarCiudad(@Valid CiudadEntity ciudad, BindingResult result, SessionStatus status){
        if(result.hasErrors()){
            return "error500";
        }
        ciudad.setEstado(true);
        iCiudadService.save(ciudad);
        status.setComplete();
        return "redirect:/listarCiudades";
    }
    @RequestMapping(value = "/eliminarCiudad/{id}")
    public String eliminarById(@PathVariable(value = "id") Long id){
        if(id>0){
            iCiudadService.remove(id);
        }else{
            return "redirect:/listarCiudades";
        }
        return "redirect:/listarCiudades";

    }

    @GetMapping("/editarCiudad/{id}")
    public String mostrarFormularioCiudad(
            @PathVariable(value = "id")Long id, Model model){
        model.addAttribute("titulo","editar ciudad");
        model.addAttribute("ciudadActualizar",iCiudadService.findOne(id));
        return "editarCiudad";
    }
    @PostMapping("editarCiudad/{id}")
    public String actualizarCiudad(
            @PathVariable(value="id") Long id,
            @ModelAttribute("ciudadactualizar")
            CiudadEntity ciudad
    ){
        CiudadEntity ciudadExistente=
                iCiudadService.findOne(id);
        ciudadExistente.setEstado(true);
        ciudadExistente.setNombre(ciudad.getNombre());


        iCiudadService.updateCiudad(ciudadExistente);
        return"redirect:/listarCiudades";
    }


}
