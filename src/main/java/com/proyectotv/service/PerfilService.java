
package com.proyectotv.service;

import com.proyectotv.domain.Perfil;
import java.util.List;

public interface PerfilService {
    
    public List<Perfil> getPerfiles();
    
    public Perfil getPerfil(Perfil perfil);
    
    public void deletePerfil(Perfil perfil);
    
    public void savePerfil(Perfil perfil);
}
