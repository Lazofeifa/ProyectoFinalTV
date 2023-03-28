
package com.proyectotv.service;

import com.proyectotv.domain.Comentario;
import java.util.List;

public interface ComentarioService {
    
    public List<Comentario> getComentarios();
    
    public Comentario getComentario(Comentario comentario);
    
    public void deleteComentario(Comentario comentario);
    
    public void saveComentario(Comentario comentario);
    
}

