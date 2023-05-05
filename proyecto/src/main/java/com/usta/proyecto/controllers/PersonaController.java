package com.usta.proyecto.controllers;


import com.usta.proyecto.entities.PersonasEntity;
import com.usta.proyecto.models.service.IEmpresasService;
import com.usta.proyecto.models.service.IPersonasService;
import com.usta.proyecto.models.service.IRegistrosService;
import com.usta.proyecto.models.service.ITelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class PersonaController {

    @Autowired
    private IPersonasService iPersonasService;

    @Autowired
    private IRegistrosService iRegistrosService;

    @Autowired
    private ITelefonoService iTelefonoService;

    @Autowired
    private IEmpresasService iEmpresasService;

    @GetMapping("listarPersonas")
    public String ListarSeccionales (Model model){
        model.addAttribute("personas",iPersonasService.findAll());
        model.addAttribute("titulos","listado Personas");
        return "listarPersonas";
    }

    @GetMapping("crearPersona")
    public String crearPersona(Model model){
        model.addAttribute("titulo","Crear Persona");
        model.addAttribute("persona",new PersonasEntity());
        model.addAttribute("registros", iRegistrosService);
        model.addAttribute("telefonos",iTelefonoService);
        model.addAttribute("empresa",iEmpresasService);
        return "crearPersona";
    }

    @PostMapping(value = "crearPersona")
    public String GuardarPersona(@Valid PersonasEntity personas, BindingResult result, SessionStatus status){
        if(result.hasErrors()){
            return "error500";
        }
        personas.setEstado(true);
        iPersonasService.save(personas);
        status.setComplete();
        return"redirect:/listarPersonas";
    }

    @RequestMapping(value ="/eliminarPersona/{id}")
    public String eliminarById(@PathVariable(value="id")Long id){
        if(id>0){
            iPersonasService.remove(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarPersonas";
    }

    @RequestMapping(value = "/cambiarEstadoPersona/{id}")
    public String cambiarEstadoPersona(@PathVariable(value = "id")Long id){
        if(id>0){
            iPersonasService.changeState(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarPersonas";
    }


    @GetMapping("/editarPersona/{id}")
    public String mostarFormularioSeccional(
            @PathVariable(value="id") Long id,Model model
    ){model.addAttribute("titulo","editar Persona");
        model.addAttribute("personaActualizar",iPersonasService.findOne(id));
        model.addAttribute("registros", iRegistrosService);
        model.addAttribute("telefonos",iTelefonoService);
        model.addAttribute("empresa",iEmpresasService);
        return "editarPersona";

    }
    @PostMapping("editarPersona/{id}")
    public String actualizarPersona(
            @PathVariable(value = "id") Long id,
            @ModelAttribute("personaActualizar")
            PersonasEntity personas
    ){
        PersonasEntity personaExistente =
                iPersonasService.findOne(id);
        personaExistente.setEstado(true);
        personaExistente.setNombre(personas.getNombre());
        personaExistente.setApellido(personas.getApellido());
        personaExistente.setCedula(personas.getCedula());
        personaExistente.setFuncionario(personas.getFuncionario());
        personaExistente.setIdRegistro(personas.getIdRegistro());
        personaExistente.setEstrato(personas.getEstrato());
        personaExistente.setPuntosDeAgua(personas.getPuntosDeAgua());
        personaExistente.setIdTelefono(personas.getIdTelefono());
        personaExistente.setIdEmpresa(personas.getIdEmpresa());
        return "redirect:/listarPersonas";
    }

}