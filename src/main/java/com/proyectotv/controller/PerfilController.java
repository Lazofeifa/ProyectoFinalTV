
package com.proyectotv.controller;

import com.proyectotv.domain.Perfil;
import com.proyectotv.service.PerfilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PerfilController {
    
    @Autowired
    PerfilService perfilService;
    
    @GetMapping("/perfil/listado")
    public String inicio(Model model) {
        var perfiles = perfilService.getPerfiles();
        model.addAttribute("perfiles", perfiles);
        return "/perfil/listado";    
    }
    
    @GetMapping("/perfil/nuevo")
    public String nuevoPerfil(Perfil perfil) {
        return "/perfil/modificar";
    }
    
    @PostMapping("/perfil/guardar")
    public String guardaPerfil(Perfil perfil) {
        perfilService.savePerfil(perfil);
        return "redirect:/perfil/listado";
    }
    
    
    @GetMapping("/perfil/eliminar/{idPerfil}")
    public String eliminaPerfil(Perfil perfil) {
        perfilService.deletePerfil(perfil);
        return "redirect:/perfil/listado";
    }
    
    @GetMapping("/perfil/modificar/{idPerfil}")
    public String modificaPerfil(Perfil perfil, Model model) {
        perfil = perfilService.getPerfil(perfil);
        model.addAttribute("perfil",perfil);
        return "/perfil/modificar";
    }
    
}
