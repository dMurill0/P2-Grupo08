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
public class TextoPlanoTest {
    
    public TextoPlanoTest() {
        EntradaGenerica textoPlano1 = new TextoPlano("Titulo","Texto");
        textoPlano1.verificar(true);
        assertTrue(textoPlano1.getVerificada());
    }

    /**
     * Test of getTitulo method, of class TextoPlano.
     */
    @Test
    public void testVerificar() {
        EntradaGenerica textoPlano1 = new TextoPlano("Titulo","Texto");
        textoPlano1.verificar(true);
        assertTrue(textoPlano1.getVerificada());
    }

    /**
     * Test of votar method, of class TextoPlano.
     */
    @Test
    public void testVotar() {
        Usuario usuario1 = new Profesor("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        EntradaGenerica textoPlano1 = new TextoPlano("Titulo", "Texto");
        textoPlano1.votar(usuario1, true);
        assertTrue(textoPlano1.votado);
        textoPlano1.votar(usuario1, false);
        assertFalse(textoPlano1.votado);
    }
    
}
