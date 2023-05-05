package com.usta.proyecto.controllers;

import com.usta.proyecto.entities.EmpresasEntity;
import com.usta.proyecto.models.service.ICiudadService;
import org.springframework.ui.Model;
import com.usta.proyecto.models.service.IEmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class EmpresaController {
    @Autowired
    private IEmpresasService iEmpresasService;

    @Autowired
    private ICiudadService iCiudadService;


    @GetMapping("listarEmpresas")
    public String listarEmpresas(Model model) {
        model.addAttribute("empresas", iEmpresasService.findAll());
        model.addAttribute("titulos", "listar Empresas");
        return "listarEmpresas";
    }

    @GetMapping("crearEmpresa")
    public String crearEmpresa(Model model) {
        model.addAttribute("titulo", "Crear Empresa");
        model.addAttribute("empresa", new EmpresasEntity());
        model.addAttribute("ciudad", iCiudadService.findAll());
        return "crearEmpresa";
    }

    @PostMapping(value = "crearEmpresa")
    public String guardarEmpresa(@Valid EmpresasEntity empresas, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "error500";
        }
        empresas.setEstado(true);
        iEmpresasService.save(empresas);
        status.setComplete();
        return "redirect:/listarEmpresas";
    }

    @RequestMapping(value = "/eliminarEmpresa/{id}")
    public String eliminarById(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            iEmpresasService.remove(id);
        } else {
            return "redirect:/error500";
        }
        return "redirect:/listarEmpresas";
    }

    @RequestMapping(value = "/cambiarEstadoEmpresa/{id}")
    public String cambiarEstadoEmpresa(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            iEmpresasService.changeState(id);
        } else {
            return "redirect:/error500";
        }
        return "redirect:/listarEmpresa";

    }

    @GetMapping("/editarEmpresa/{id}")
    public String mostrarFormulariosEmpresa(
            @PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("titulo", "editar Empresa");
        model.addAttribute("empresaActualizar",iEmpresasService.findOne(id));
        model.addAttribute("ciudad",iCiudadService.findAll());
        return "editarEmpresa";

    }

    @PostMapping("editarEmpresa/{id}")
    public String actualizarEmpresa(
            @PathVariable(value = "Id") Long id,
            @ModelAttribute("empresaActualizar")
            EmpresasEntity empresas

    ){
        EmpresasEntity empresaExistente =
                iEmpresasService.findOne(id);
        empresaExistente.setEstado(true);
        empresaExistente.setNit(empresas.getNit());
        empresaExistente.setNombre(empresas.getNombre());
        empresaExistente.setIdciudad(empresas.getIdciudad());
        iEmpresasService.updateEmpresas(empresaExistente);
        return "redirect:/listarEmpresas";
    }
}




