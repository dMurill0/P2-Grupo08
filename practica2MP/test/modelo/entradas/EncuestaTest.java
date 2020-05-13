/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entradas;

import modelo.usuario.Profesor;
import modelo.usuario.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergiomartin
 */
public class EncuestaTest {

    /**
     * Test of getTitulo method, of class Encuesta.
     */

    @Test
    public void testVerificar() {
        EntradaGenerica encuesta1 = new Encuesta("Titulo","Texto");
        encuesta1.verificar(true);
        assertTrue(encuesta1.getVerificada());
    }

    /**
     * Test of votar method, of class Encuesta.
     */
    @Test
    public void testVotar() {
        Usuario usuario1 = new Profesor("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        EntradaGenerica encuesta1 = new Encuesta("Titulo", "Texto");
        encuesta1.votar(usuario1, true);
        assertTrue(encuesta1.votado);
        encuesta1.votar(usuario1, false);
        assertFalse(encuesta1.votado);
    }
    
}
