
package com.proyectotv.controller;


import com.proyectotv.domain.Ubicacion;
import com.proyectotv.service.UbicacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UbicacionController{
    
    @Autowired
    UbicacionService ubicacionService;
    
    @GetMapping("/ubicacion/listado")
    public String inicio(Model model) {
        var ubicaciones = ubicacionService.getUbicaciones();
        model.addAttribute("ubicaciones", ubicaciones);
        return "/ubicacion/listado";    
    }
    
    @GetMapping("/ubicacion/nuevo")
    public String nuevoUbicacion(Ubicacion ubicacion) {
        return "/ubicacion/modificar";
    }
    
    @PostMapping("/ubicacion/guardar")
    public String guardaUbicacion(Ubicacion ubicacion) {
        ubicacionService.saveUbicacion(ubicacion);
        return "redirect:/ubicacion/listado";
    }
    
    
    @GetMapping("/ubicacion/eliminar/{idUbicacion}")
    public String eliminaUbicacion(Ubicacion ubicacion) {
        ubicacionService.deleteUbicacion(ubicacion);
        return "redirect:/ubicacion/listado";
    }
    
    @GetMapping("/ubicacion/modificar/{idUbicacion}")
    public String modificaUbicacion(Ubicacion ubicacion, Model model) {
        ubicacion = ubicacionService.getUbicacion(ubicacion);
        model.addAttribute("ubicacion",ubicacion);
        return "/ubicacion/modificar";
    }
    
}
