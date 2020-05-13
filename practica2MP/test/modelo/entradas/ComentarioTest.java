/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entradas;

import org.junit.Test;

import modelo.usuario.Usuario;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 *
 * @author sergiomartin
 */
public class ComentarioTest {
    /**
     * Test of comentar method, of class Comentario.
     */
    @Test
    public void testComentar(){
        String texto = "Texto";
        ArrayList <> respuestas = new ArrayList<Comentario>();
        respuestas.add(texto);
        int n = respuestas.size();
        assertEquals(respuestas.get(n), texto);
    }

    /**
     * Test of votar method, of class Comentario.
     */
    @Test
    public void testVotar() {
        Usuario alumno = new Usuario();
        Comentario comentario = new Comentario();
        Boolean valor = true;
        int puntuacion = 1;
        alumno.votarEntrada(comentario, puntuacion);
        assertFalse(comentario.votar(usuario, valor));

    }
    
}
