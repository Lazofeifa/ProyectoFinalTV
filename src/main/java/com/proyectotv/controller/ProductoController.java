
package com.proyectotv.controller;

import com.proyectotv.domain.Producto;
import com.proyectotv.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        return "/producto/listado";    
    }
    
    @GetMapping("/nuevo")
    public String nuevoProducto(Producto producto) {
        return "/producto/modificar";
    }
    
    @PostMapping("/guardar")
    public String guardaProducto(Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/producto/listado";
    }
    
    
    @GetMapping("/eliminar/{idProducto}")
    public String eliminaProducto(Producto producto) {
        productoService.deleteProducto(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/modificar/{idProducto}")
    public String modificaProducto(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto",producto);
        return "/producto/modificar";
    }
}
