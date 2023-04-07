package com.proyectotv.controller;

import com.proyectotv.domain.Cliente;
import com.proyectotv.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";    
    }
    
    @GetMapping("/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modifica";
    }
    
    @PostMapping("/guardar")
    public String guardaCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente/listado";
    }
    
    
    @GetMapping("/eliminar/{idCliente}")
    public String eliminaCliente(Cliente cliente) {
        clienteService.deleteCliente(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/modificar/{idCliente}")
    public String modificaCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "/cliente/modifica";
    }
    
}
