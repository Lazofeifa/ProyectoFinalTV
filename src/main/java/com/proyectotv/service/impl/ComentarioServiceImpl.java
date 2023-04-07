
package com.proyectotv.service.impl;

import com.proyectotv.dao.ComentarioDao;
import com.proyectotv.dao.ProductoDao;
import com.proyectotv.domain.Comentario;
import com.proyectotv.domain.Producto;
import com.proyectotv.service.ComentarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServiceImpl implements ComentarioService{
    
    @Autowired
    private ComentarioDao comentarioDao;
    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public List<Comentario> getComentarios() {
        return comentarioDao.findAll();
    }
    
    @Override
    public Comentario getComentario(Comentario comentario) {
        return comentarioDao.findById(comentario.getIdComentario()).orElse(null);
    }

    @Override
    public void deleteComentario(Comentario comentario) {
        comentarioDao.delete(comentario);
    }
    
    @Override
    public void saveComentario(Comentario comentario) {
        Producto producto = comentario.getProducto();
        producto = productoDao.save(producto);
        comentario.setProducto(producto);
        comentarioDao.save(comentario);
    }
}
