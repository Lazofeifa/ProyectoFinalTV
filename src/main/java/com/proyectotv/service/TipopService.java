
package com.proyectotv.service;

import com.proyectotv.domain.Tipop;
import java.util.List;

public interface TipopService {
    
    public List<Tipop> getTipops();
    
    public Tipop getTipop(Tipop Tipop);
    
    public void deleteTipop(Tipop Tipop);
    
    public void saveTipop(Tipop Tipop);
}
