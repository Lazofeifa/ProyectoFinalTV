package com.proyectotv.controller;

import com.proyectotv.domain.Comentario;
import com.proyectotv.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {
    
    @Autowired
    ComentarioService comentarioService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var comentarios = comentarioService.getComentarios();
        model.addAttribute("comentarios", comentarios);
        return "/comentario/listado";    
    }
    
    @GetMapping("/nuevo")
    public String nuevoComentario(Comentario comentario) {
        return "/comentario/modificar";
    }
    
    @PostMapping("/guardar")
    public String guardaComentario(Comentario comentario) {
        comentarioService.saveComentario(comentario);
        return "redirect:/comentario/listado";
    }
    
    
    @GetMapping("/eliminar/{idComentario}")
    public String eliminaComentario(Comentario comentario) {
        comentarioService.deleteComentario(comentario);
        return "redirect:/comentario/listado";
    }
    
    @GetMapping("/modificar/{idComentario}")
    public String modificaComentario(Comentario comentario, Model model) {
        comentario = comentarioService.getComentario(comentario);
        model.addAttribute("comentario",comentario);
        return "/comentario/modificar";
    }
    
}
