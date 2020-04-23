package modelo;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergiomartin
 */
public class Usuario {
    
    private String nombre ;
    private String apellidos;
    private String nick;
    private String contraseña;
    private String email;
    private String rol; //indicar en la creacion de usuario si es alumno,profesor o admin y comparar con equalsIgnoreCase
    private ArrayList<String> notificaciones;

    public Usuario(String nombre, String apellidos, String nick, String contraseña, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nick = nick;
        this.contraseña = contraseña;
        this.email = email;
        this.rol = rol;
        this.notificaciones = notificaciones;
    }
    
    
 
    public void recibirNotificacion(String notificacion){
        notificaciones.add(notificacion);
    }

    public ArrayList<String> getNotificaciones() {
        return notificaciones;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return contraseña;
    }

    public void setPassword(String contraseña) {
        this.contraseña = contraseña;
    }

    
}
