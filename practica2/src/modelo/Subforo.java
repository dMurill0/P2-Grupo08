package modelo;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author celia
 */
public class Subforo implements Subject{
    private String titulo;
    private ArrayList<Usuario> alUsuarios;
    private ArrayList<Entrada> alEntradas;
    
    public Subforo(String titulo){
        this.titulo = titulo;
    }
     //???
    @Override
    public void anadirSubscriptor(Usuario subs) {
        //Añadir un usuario a un subforo en la BD
        alUsuarios.add(subs);
    }
       
     //???
    @Override
    public void eliminarSubscriptor(Usuario subs) {
        //Eliminar un usuario a un subforo en la BD
        alUsuarios.remove(subs);
    }
    
    @Override
    public void notificar() {
        for (Usuario usuario: alUsuarios){
            usuario.recibirNotificacion("Se realizó un cambio en el Subforo: " + this.titulo);
        }
    }
    
   
}
