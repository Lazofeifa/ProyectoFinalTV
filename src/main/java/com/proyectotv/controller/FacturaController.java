
package com.proyectotv.controller;

import com.proyectotv.domain.Factura;
import com.proyectotv.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class FacturaController {
    @Autowired
    FacturaService facturaService;
    
    @GetMapping("/factura/listado")
    public String inicio(Model model) {
        var facturas = facturaService.getFacturas();
        model.addAttribute("facturas", facturas);
        return "/factura/listado";    
    }
    
    @GetMapping("/factura/nuevo")
    public String nuevofactura(Factura factura) {
        return "/factura/modificar";
    }
    
    @PostMapping("/factura/guardar")
    public String guardaFactura(Factura factura) {
        facturaService.saveFactura(factura);
        return "redirect:/factura/listado";
    }
    
    
    @GetMapping("/factura/eliminar/{idFactura}")
    public String eliminaFactura(Factura factura) {
        facturaService.deleteFactura(factura);
        return "redirect:/factura/listado";
    }
    
    @GetMapping("/factura/modificar/{idFactura}")
    public String modificaFactura(Factura factura, Model model) {
        factura = facturaService.getFactura(factura);
        model.addAttribute("factura",factura);
        return "/factura/modificar";
    }
}
