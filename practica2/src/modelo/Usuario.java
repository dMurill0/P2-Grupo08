package modelo;


import java.util.ArrayList;


public class Usuario implements Subscriptor{
    private int id;
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
    
   
    public ArrayList<String> getNotificaciones() {
        return notificaciones;
    }

    public int getId(){
        return this.id;
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

    @Override
    public void recibirNotificaciones(String notificacion) {
        notificaciones.add(notificacion);

    }

    
}
