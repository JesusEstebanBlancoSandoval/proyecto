package com.usta.proyecto.controllers;


import com.usta.proyecto.entities.TelefonoEntity;
import com.usta.proyecto.models.service.ITelefonoService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class TelefonoController {
    @Autowired
    private ITelefonoService iTelefonoService;

    @GetMapping("listarTelefonos")
    public String listarTelefono (Model model){
        model.addAttribute("telefono",iTelefonoService.findAll());
        model.addAttribute("titulos","listado Telefono");
        return "listarTelefonos";
    }



    @GetMapping("crearTelefono")
    public String listarTelefonos(Model model){
        model.addAttribute("titulo","crear telefono");
        model.addAttribute("telefono", new TelefonoEntity());
        return "crearTelefono";


    }

    @PostMapping(value = "crearTelefono")
    public String guardarTelefono(@Valid TelefonoEntity telefono, BindingResult result, SessionStatus status){
        if(result.hasErrors()){
            return "error500";
        }
        telefono.setEstado(true);
        iTelefonoService.save(telefono);
        status.setComplete();
        return "redirect:/listarTelefonos";

    }

    @RequestMapping(value = "/eliminarTelefono/{id}")
    public String elminarById(@PathVariable(value = "id") Long id){
        if(id>0){
            iTelefonoService.remove(id);

        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarTelefonos";
    }
    @RequestMapping(value = "/cambiarEstadoTelefono/{id}")
    public String cambiarEstadoTelefono(@PathVariable(value = "id")Long id){
        if (id > 0) {
            iTelefonoService.changeState(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarTelefonos";
        }


    @GetMapping("/editarTelefono/{id}")
    public String mostrarFormulariosTelefono(
            @PathVariable(value = "id") Long id,Model model){
        model.addAttribute("titulo","editar telefono");
        model.addAttribute("telefonoActualizar",iTelefonoService.findOne(id));
        return "editarTelefono";

    }
    @PostMapping("editarTelefono/{id}")
    public String actualizarTelefono(
            @PathVariable(value = "id") Long id,
            @ModelAttribute("telefonoActualizar")
            TelefonoEntity telefono
    ){
        TelefonoEntity telefonoExistente =
                iTelefonoService.findOne(id);
        telefonoExistente.setEstado(true);
        telefonoExistente.setNumero(telefono.getNumero());
        telefonoExistente.setTipo(telefono.getTipo());
        return "redirect:/listarTelefonos";
    }


}






