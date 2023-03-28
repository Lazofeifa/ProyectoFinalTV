
package com.proyectotv.controller;

import com.proyectotv.domain.Producto;
import com.proyectotv.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ProductoController {
    @Autowired
    ProductoService productoService;
    
    @GetMapping("/producto/listado")
    public String inicio(Model model) {
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        return "/producto/listado";    
    }
    
    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto) {
        return "/producto/modificar";
    }
    
    @PostMapping("/producto/guardar")
    public String guardaProducto(Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/producto/listado";
    }
    
    
    @GetMapping("/producto/eliminar/{idProducto}")
    public String eliminaProducto(Producto producto) {
        productoService.deleteProducto(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/producto/modificar/{idProducto}")
    public String modificaProducto(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto",producto);
        return "/producto/modificar";
    }
}
