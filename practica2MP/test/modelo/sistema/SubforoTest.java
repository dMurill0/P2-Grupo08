package modelo.sistema;
import modelo.usuario.Alumno;
import org.junit.Test;

import modelo.usuario.Usuario;
import static org.junit.Assert.assertTrue;

import org.junit.Before;    
    
public class SubforoTest {

        
    @Test
    public void anadirSubscriptorTest() {
        Subforo subforo = new Subforo("test");
        Usuario alumno = new Alumno("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        assertTrue(subforo.anadirSubscriptor(alumno));
        
    
}

    @Test 
    public void eliminarSubscriptorTest(){
        Subforo subforo1 = new Subforo("test");
        Usuario alumno1 = new Alumno("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        assertTrue(subforo1.eliminarSubscriptor(alumno1));
    }
    
   
}