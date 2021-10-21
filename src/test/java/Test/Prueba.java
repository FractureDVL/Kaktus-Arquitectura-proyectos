
package Test;

import java.util.ArrayList;
import modelo.UsuarioDTO;

public class Prueba {
    
    public static void main(String[] args) {
        ArrayList<UsuarioDTO> l = new ArrayList();
        
        UsuarioDTO u = new UsuarioDTO("a","a","a,","a");
        UsuarioDTO u1 = new UsuarioDTO("Peppa pig","peppa@usps.edu.co","PeppaAssassin77","Peppa123");
        
        l.add(u);
        l.add(u1);
        
        for(UsuarioDTO u2: l){
            System.out.println(u2);
        }
    }
    
}
