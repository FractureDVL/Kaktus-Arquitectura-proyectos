/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionProyectos;

import dao.ProyectoDAO;
import entidades.ProyectoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseb
 */
public class ProyectoNegocio {
    private ProyectoDAO proyectodao;

    //Contructor
    public ProyectoNegocio() {
        proyectodao = new ProyectoDAO();
    }

    //Metodo get usuarios
    public List<ProyectoDTO> buscarProyectos() {
        List<ProyectoDTO> proyectos = new ArrayList<ProyectoDTO>();

        try {
            proyectos = proyectodao.buscarProyectos();
        } catch (Exception e) {
            e.printStackTrace();
            proyectos = null;
        }

        return proyectos;
    }
     public List<ProyectoDTO> buscarProyectosUser(String username) {
        List<ProyectoDTO> proyectos = new ArrayList<ProyectoDTO>();

        try {
            proyectos = proyectodao.buscarProyectosUser(username);
        } catch (Exception e) {
            e.printStackTrace();
            proyectos = null;
        }

        return proyectos;
    }

    public boolean crearProyecto(ProyectoDTO proyecto) {
        boolean rta = false;
        try {
            rta = proyectodao.crearProyecto(proyecto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rta;
    }

    public int eliminarProyecto(ProyectoDTO proyecto) {
        int rta = 0;

        try {
            rta = proyectodao.eliminarProyecto(proyecto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rta;
    }

    public int actualizarProyecto(ProyectoDTO proyecto) {

        int rta = 0;

        try {

            rta = proyectodao.actualizarProyecto(proyecto);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return rta;
    }   
}
