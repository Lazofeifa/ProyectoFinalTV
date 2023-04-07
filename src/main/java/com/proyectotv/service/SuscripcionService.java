
package com.proyectotv.service;

import com.proyectotv.domain.Suscripcion;
import java.util.List;


public interface SuscripcionService {
    
    public List<Suscripcion> getSuscripciones();
    
    public Suscripcion getSuscripcion(Suscripcion suscripcion);
    
    public void deleteSuscripcion(Suscripcion suscripcion);
    
    public void saveSuscripcion(Suscripcion suscripcion);
}
