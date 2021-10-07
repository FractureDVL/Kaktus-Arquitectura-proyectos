package modelo;

import java.util.ArrayList;


public class ListaUsuarios {
    
    private ArrayList<Usuario> lista = new ArrayList();

    public ListaUsuarios() {
    }
    
    public void agregarUsuario(Usuario u){
        lista.add(u);
    }
    
    public ArrayList<Usuario> getLista() {
        return lista;
    }
    
    public void setLista(ArrayList<Usuario> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "ListaUsuarios{" + "lista=" + lista + '}';
    }
    
    
    
}
