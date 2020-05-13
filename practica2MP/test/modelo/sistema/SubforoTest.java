package modelo.sistema;
import org.junit.Test;

import modelo.usuario.Usuario;

import org.junit.Before;    
    
public class SubforoTest {

        
    @Test
    public void anadirSubscriptorTest() {
        Subforo subforo = new Subforo();
        Usuario alumno = new Usuario("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        assertTrue(subforo.anadirSubscriptor(alumno));
        
    
}

    @Test 
    public void eliminarSubscriptorTest(){
        Subforo subforo1 = new Subforo();
        Usuario alumno1 = new Usuario("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        assertTrue(subforo1.eliminarSubscriptor(alumno1));
    }
    
   
}