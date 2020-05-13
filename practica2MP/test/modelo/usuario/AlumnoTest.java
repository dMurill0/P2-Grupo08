/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import modelo.entradas.EntradaGenerica;
import modelo.entradas.TextoPlano;
import modelo.sistema.Penalizacion;
import modelo.sistema.Subforo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergiomartin
 */
public class AlumnoTest {

    /**
     * Test of penalizar method, of class Alumno.
     */
    @Test
    public void testPenalizar() {
        Alumno alumno1 = new Alumno("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        Penalizacion penaliz = new Penalizacion(2);
        alumno1.setPenaliz(penaliz);
        assertTrue(alumno1.estaPenalizado());
    }
    @Test
    public void testCrearEntrada() {
        EntradaGenerica textoPlano = new TextoPlano("Titulo", "Texto");
        Subforo subforo = new Subforo("Subforo");
        subforo.setAlEntradas(textoPlano);
        assertEquals(textoPlano.getTexto(),"Texto");
        assertEquals(textoPlano.getTitulo(),"Titulo");
        
    }
    
}
