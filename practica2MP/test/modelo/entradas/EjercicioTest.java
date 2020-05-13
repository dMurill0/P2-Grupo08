package modelo.entradas;
import org.junit.Test;

import modelo.usuario.Usuario;

import org.junit.Before;    
    
public class EjercicioTest {

    @Test
    public void testVotar() {
        Usuario alumno = new Usuario();
        EntradaGenerica ejercicio = new Ejercicio();
        Boolean valor = false;
        int puntuacion = 1;
        alumno.votarEntrada(ejercicio, puntuacion);
        assertTrue(comentario.votar(usuario, valor));

    }  
    
}
    