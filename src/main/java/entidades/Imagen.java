/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.InputStream;
import java.util.Objects;

/**
 *
 * @author Diego Pedrozo
 */
public class Imagen {
    
    int id;
    String nombre;
    InputStream imagen;
    private byte[] img;
    String usuario;
    
    public Imagen(){
    
    }

    public Imagen(int id, String nombre, InputStream imagen, byte[] img, String usuario) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.img = img;
        this.usuario = usuario;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Imagen other = (Imagen) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagen{" + "id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", img=" + img + ", usuario=" + usuario + '}';
    } 
}
