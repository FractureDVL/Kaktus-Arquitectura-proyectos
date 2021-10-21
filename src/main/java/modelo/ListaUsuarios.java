package modelo;

import java.util.ArrayList;


public class ListaUsuarios {
    
    private ArrayList<UsuarioDTO> lista = new ArrayList();

    public ListaUsuarios() {
    }
    
    public void agregarUsuario(UsuarioDTO u){
        lista.add(u);
    }
    
    public ArrayList<UsuarioDTO> getLista() {
        return lista;
    }
    
    public void setLista(ArrayList<UsuarioDTO> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "ListaUsuarios{" + "lista=" + lista + '}';
    }
    
    
    
}
