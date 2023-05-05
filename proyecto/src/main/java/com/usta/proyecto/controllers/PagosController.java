package com.usta.proyecto.controllers;

import com.usta.proyecto.entities.PagosEntity;
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
public class PagosController {

    @Autowired
    private IPagosService iPagosService;

    @Autowired
    private IDetallesService iDetallesService;

    @Autowired
    private IRegistrosService iRegistrosService;

    @GetMapping("listarPagos")
    public String listarPagos(Model model) {
        model.addAttribute("pagos", iPagosService.findAll());
        model.addAttribute("titulos", "listado Pagos");
        return "listarPagos";
    }

    @GetMapping("crearPagos")
    public String crearPagos(Model model) {
        model.addAttribute("titulo", "Crear Pago");
        model.addAttribute("pago", new PagosEntity());
        model.addAttribute("detalles", iDetallesService.findAll());
        model.addAttribute("registros", iRegistrosService.findAll());
        return "crearPagos";
    }


    @PostMapping(value = "crearPagos")
    public String guardarPago(@Valid PagosEntity pagos, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "error500";
        }
        pagos.setEstado(true);
        iPagosService.save(pagos);
        status.setComplete();
        return "redirect:/listarPagos";
    }

    @RequestMapping(value = "/eliminarPagos/{id}")
    public String eliminarById(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            iPagosService.changeState(id);
        } else {
            return "redirect:/error500";
        }
        return "redirect:/listarPagos";
    }

    @GetMapping("/editarPago/{id}")
    public String mostrarFormularioPago(
            @PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("titulo", "editar Pago");
        model.addAttribute("pago", iPagosService.findOne(id));
        model.addAttribute("detalles", iDetallesService.findAll());
        model.addAttribute("registros", iRegistrosService.findAll());
        return "editarPagos";
    }
    @PostMapping("editarPago/{id}")
    public String actualizarPago(
            @PathVariable(value = "id")Long id,
            @ModelAttribute("pagoActualizar")
            PagosEntity pagos
    ){
        PagosEntity pagoExistente =
                iPagosService.findOne(id);
        pagoExistente.setEstado(true);
        pagoExistente.setIdRegistro(pagos.getIdRegistro());
        pagoExistente.setPagoAlDia(pagos.getPagoAlDia());
        pagoExistente.setIdDetalles(pagos.getIdDetalles());
        iPagosService.updatePagos(pagoExistente);
        return "redirect:/listarPagos";
    }
}


