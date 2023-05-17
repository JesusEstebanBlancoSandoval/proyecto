package com.usta.proyecto.controllers;

import com.usta.proyecto.entities.DetallesEntity;
import com.usta.proyecto.models.service.IDetallesService;
import com.usta.proyecto.models.service.IPagosService;
import com.usta.proyecto.models.service.IRegistrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class DetallesController {
    @Autowired
    private IDetallesService iDetallesService;


    @Autowired
    private IPagosService iPagosService;

    @GetMapping("gestorTablas/detallesTabla")
    public String listarDetalles (Model model){
        model.addAttribute("Detalles",iDetallesService.findAll());
        return "gestorTablas/detallesTabla";
    }

    @GetMapping("crearDetalles")
    public String crearDetalles(Model model){
        model.addAttribute("titulo","crear Detalle");
        model.addAttribute("Detalle",new DetallesEntity());
        model.addAttribute("pagos",iPagosService.findAll());
        return "crearDetalles";

    }

    @PostMapping(value = "crearDetalles")
    public String guardarDetalles(@Valid DetallesEntity detalles, BindingResult result, SessionStatus status){
        if(result.hasErrors()){
            return "error500";
        }
        detalles.setEstado(true);
        iDetallesService.save(detalles);
        status.setComplete();
        return "redirect:/listarDetalles";
    }

    @RequestMapping(value="/eliminarDetalle/{id}")
    public String eliminarById(@PathVariable(value = "id")Long id){
        if(id>0){
            iDetallesService.remove(id);
        }else{
            return "redirect:/500";
        }
        return "redirect:/listarDetalles";

    }
    @RequestMapping(value = "/cambiarEstadoDetalles/{id}")
    public String cambiarEstadoDetalle(@PathVariable(value = "id")Long id){
        if(id>0){
            iDetallesService.changeState(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarDetalles";
    }
    @GetMapping("/editarDetalles/{id}")
    public String mostrarFormularioDetalle(
            @PathVariable(value = "id")Long id, Model model){
        model.addAttribute("titulo","editar Detalle");
        model.addAttribute("Detalle",iDetallesService.findOne(id));
        model.addAttribute("pagos",iPagosService.findAll());
        return "editarDetalles";

    }

    @PostMapping("editarDetalles/{id}")
    public String actualizarDetalle(
            @PathVariable(value = "id") Long id,
            @ModelAttribute("detalleActualizar")
            DetallesEntity detalles
    ){
        DetallesEntity detalleExistente =
                iDetallesService.findOne(id);
        detalleExistente.setEstado(true);
        detalleExistente.setIdpago(detalles.getIdpago());
        detalleExistente.setMedicionActual(detalles.getMedicionActual());
        detalleExistente.setCostoAPagar(detalles.getMedicionActual()*700);//en esta parte se debe hacer la regla de tres para que al poner la medicion se calcule el costo a pagar//
        detalleExistente.setMedicionPasada(detalles.getMedicionPasada());
        detalleExistente.setCostoPasado(detalles.getCostoPasado());
        detalleExistente.setDeudaTotal(detalles.getDeudaTotal());
        iDetallesService.updateDetalles(detalleExistente);
        return "redirect:/listarDetalles";

    }

}
