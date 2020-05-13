/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import modelo.entradas.Ejercicio;
import modelo.entradas.Encuesta;
import modelo.entradas.EntradaGenerica;
import modelo.entradas.TextoPlano;
import modelo.sistema.Subforo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergiomartin
 */
public class ProfesorTest {
    
    public ProfesorTest() {
    }

    /**
     * Test of crearEncuesta method, of class Profesor.
     */
    @Test
    public void testCrearEncuesta() {
        EntradaGenerica encuesta = new Encuesta("Titulo","Test");
        Administrador admin1 = new Administrador("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        assertTrue(admin1.verificarEntrada(encuesta));
    }

    /**
     * Test of crearEjercicio method, of class Profesor.
     */
    @Test
    public void testCrearEjercicio() {
        EntradaGenerica ejercicio = new Ejercicio("Titulo","Test");
        Administrador admin1 = new Administrador("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        assertTrue(admin1.verificarEntrada(ejercicio));
    }

    /**
     * Test of crearTextoPlano method, of class Profesor.
     */
    @Test
    public void testCrearTextoPlano() {
        EntradaGenerica textoPlano = new TextoPlano("Titulo","Test");
        Administrador admin1 = new Administrador("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        assertTrue(admin1.verificarEntrada(textoPlano));
    }

    /**
     * Test of crearSubfboro method, of class Profesor.
     */
    @Test
    public void testCrearSubfboro() {
        
    }

    /**
     * Test of crearEntrada method, of class Profesor.
     */
    @Test
    public void testCrearEntrada() {
        
    }
    
}
