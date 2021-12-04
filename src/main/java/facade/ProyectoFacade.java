/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.ProyectoDTO;
import gestionProyectos.ProyectoNegocio;
import java.util.List;

/**
 *
 * @author joseb
 */
public class ProyectoFacade {
        
    private ProyectoNegocio proyectoNegocio;

    public ProyectoFacade() {
        proyectoNegocio = new ProyectoNegocio();
    }
    
    public List<ProyectoDTO> buscarProyectos(){
        return proyectoNegocio.buscarProyectos();
    }
    
    public int eliminarProyecto(ProyectoDTO proyecto){
        return proyectoNegocio.eliminarProyecto(proyecto);
    }
    
    public int actualizarProyecto(ProyectoDTO proyecto){
        return proyectoNegocio.actualizarProyecto(proyecto);    
    }
    
    public boolean crearUsuario(ProyectoDTO proyecto){
        return proyectoNegocio.crearProyecto(proyecto);
    }
    
}
