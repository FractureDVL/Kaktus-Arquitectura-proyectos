
package Test;

import java.util.ArrayList;
import modelo.Usuario;

public class Prueba {
    
    public static void main(String[] args) {
        ArrayList<Usuario> l = new ArrayList();
        
        Usuario u = new Usuario("a","a","a,","a");
        Usuario u1 = new Usuario("Peppa pig","peppa@usps.edu.co","PeppaAssassin77","Peppa123");
        
        l.add(u);
        l.add(u1);
        
        for(Usuario u2: l){
            System.out.println(u2);
        }
    }
    
}
