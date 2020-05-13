/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.sistema;

import java.util.ArrayList;
import modelo.usuario.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergiomartin
 */
public class SistemaTest {
    /**
     * Test of anadirSubforo method, of class Sistema.
     */

    /**
     * Test of login method, of class Sistema.
     */
    @Test
    public void testLogin() {
        Sistema sistema = new Sistema();
        boolean respuesta = sistema.login("nick1", "contraseña");
        assertFalse(respuesta);
    }

    /**
     * Test of logout method, of class Sistema.
     */
    @Test
    public void testLogout() {
        Sistema sistema = new Sistema();
        sistema.registrarUsuario("Nombre1", "Apellidos1", "nick1", "Password1", "nombre@urjc.es");
        boolean respuesta = sistema.logout();
        assertTrue(respuesta);
    }

    /**
     * Test of registrarUsuario method, of class Sistema.
     */
    @Test
    public void testRegistrarUsuario() {
        Sistema sistema = new Sistema();
        sistema.registrarUsuario("Nombre1", "Apellidos1", "nick1", "Password1", "nombre@urjc.es");
        sistema.login("nick1", "Password1");
        Usuario usuario = sistema.getUsuarioConectado();
        assertEquals(usuario.getNick(),"nick1");
    }
    /**
     * Test of crearSubforo method, of class Sistema.
     */
    @Test
    public void testCrearSubforo() {
        Sistema sistema = new Sistema();
        String titulo = "Titulo1";
        Subforo subforo = sistema.crearSubforo(titulo);
        
        assertEquals(subforo.getTitulo(),titulo);
        
    }

    /**
     * Test of getUsuarioConectado method, of class Sistema.
     */
    @Test
    public void testGetUsuarioConectado(){
        Sistema sistema = new Sistema();
        sistema.registrarUsuario("Nombre1", "Apellidos1", "nick1", "Password1", "nombre@urjc.es");
        sistema.login("nick1", "Password1");
        Usuario usuario = sistema.getUsuarioConectado();
        assertEquals(usuario.getNick(),"nick1");
    }

    /**
     * Test of getUsuarios method, of class Sistema.
     */
    @Test
    public void testGetUsuarios(){
        Sistema sistema = new Sistema();
        sistema.registrarUsuario("Nombre1", "Apellidos1", "nick1", "Password1", "nombre@urjc.es");
        sistema.login("nick1", "Password1");
        sistema.registrarUsuario("Nombre2", "Apellidos2", "nick2", "Password2", "nombre2@urjc.es");
        sistema.login("nick2", "Password2");
        ArrayList<Usuario> lista = sistema.getUsuarios();
        assertEquals(lista.size(),2);
    }

    /**
     * Test of getSubforos method, of class Sistema.
     */
    @Test
    public void testGetSubforos(){
        Sistema sistema = new Sistema();
        Subforo subforo1 = new Subforo("Subforo1");
        Subforo subforo2 = new Subforo("Subforo2");
        sistema.anadirSubforo(subforo1);
        sistema.anadirSubforo(subforo2);
        ArrayList<Subforo> lista = sistema.getSubforos();
        assertEquals(lista.size(),2);
    }
    
}
