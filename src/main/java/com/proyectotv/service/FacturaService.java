
package com.proyectotv.service;

import com.proyectotv.domain.Factura;
import java.util.List;


public interface FacturaService {
    
    public List<Factura> getFacturas();
    
    public Factura getFactura(Factura factura);
    
    public void deleteFactura(Factura factura);
    
    public void saveFactura(Factura factura);
}
