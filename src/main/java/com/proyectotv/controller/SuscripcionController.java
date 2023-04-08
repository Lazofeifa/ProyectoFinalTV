
package com.proyectotv.controller;

import com.proyectotv.domain.Suscripcion;
import com.proyectotv.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/suscripcion")
public class SuscripcionController {
    
    @Autowired
    SuscripcionService suscripcionService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var suscripciones = suscripcionService.getSuscripciones();
        model.addAttribute("suscripciones", suscripciones);
        return "/suscripcion/listado";    
    }
    
    @GetMapping("/nuevo")
    public String nuevoSuscripcion(Suscripcion suscripcion) {
        return "/suscripcion/modificar";
    }
    
    @PostMapping("/guardar")
    public String guardaSuscripcion(Suscripcion suscripcion) {
        suscripcionService.saveSuscripcion(suscripcion);
        return "redirect:/suscripcion/listado";
    }
    
    
    @GetMapping("/eliminar/{idSuscripcion}")
    public String eliminaSuscripcion(Suscripcion suscripcion) {
        suscripcionService.deleteSuscripcion(suscripcion);
        return "redirect:/suscripcion/listado";
    }
    
    @GetMapping("/modificar/{idSuscripcion}")
    public String modificaSuscripcion(Suscripcion suscripcion, Model model) {
        suscripcion = suscripcionService.getSuscripcion(suscripcion);
        model.addAttribute("suscripcion",suscripcion);
        return "/suscripcion/modificar";
    }
}
