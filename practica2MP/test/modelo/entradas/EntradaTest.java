/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entradas;

import modelo.usuario.Administrador;
import modelo.usuario.Profesor;
import modelo.usuario.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergiomartin
 */
public class EntradaTest {
    /**
     * Test of comentar method, of class Entrada.
     */
    @Test
    public void testComentar() {
        Comentario comentario = new Comentario("TextoPrueba");
        assertEquals(comentario.getComentario(),"TextoPrueba");
    }

    @Test
    public void testVerificar() {
        EntradaGenerica entrada1 = new Entrada("Titulo","Texto");
        entrada1.verificar(true);
        assertTrue(entrada1.getVerificada());
    }

    /**
     * Test of votar method, of class Entrada.
     */
    @Test
    public void testVotar(){
        Usuario usuario1 = new Profesor("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        EntradaGenerica entrada1 = new Entrada("Titulo", "Texto");
        entrada1.votar(usuario1, true);
        assertTrue(entrada1.votado);
        entrada1.votar(usuario1, false);
        assertFalse(entrada1.votado);
    }
    
}
