/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import modelo.entradas.EntradaGenerica;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergiomartin
 */
public class AdministradorTest {
    /**
     * Test of penalizar method, of class Administrador.
     */
    @Test
    public void testPenalizar(){
        Alumno alumno1 = new Alumno("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        alumno1.penalizar(2);
        Alumno alumno2 = new Alumno("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        alumno2.getPenaliz().setDiasPenalizacion(2);
        assertEquals(alumno1.getPenaliz().getDiasPenalizacion(),
        alumno2.getPenaliz().getDiasPenalizacion());
    }

    /**
     * Test of verificarEntrada method, of class Administrador.
     */
    @Test
    public void testVerificarEntrada() {
        EntradaGenerica entrada = null;
        Administrador admin1 = new Administrador("Pepe","Sanjuán","Pepito","123456","pepe.sanjuan@alumnos.urjc.es");
        assertFalse(admin1.verificarEntrada(entrada));
        
        
    }
    
}
