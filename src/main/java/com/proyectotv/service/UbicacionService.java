
package com.proyectotv.service;

import com.proyectotv.domain.Ubicacion;
import java.util.List;

public interface UbicacionService {
    
    public List<Ubicacion> getUbicaciones();
    
    public Ubicacion getUbicacion(Ubicacion ubicacion);
    
    public void deleteUbicacion(Ubicacion ubicacion);
    
    public void saveUbicacion(Ubicacion ubicacion);
}
