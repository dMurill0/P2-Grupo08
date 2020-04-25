package modelo.usuario;


import java.util.ArrayList;
import modelo.Suscriptor;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGenerica;
import modelo.sistema.Subforo;


public class Usuario implements Suscriptor{
   
    
    private Entrada entrada;
    private String nombre ;
    private String apellidos;
    private String nick;
    private String contraseña;
    private String email;
    private String rol; //indicar en la creacion de usuario si es alumno,profesor o admin y comparar con equalsIgnoreCase
    private ArrayList<String> notificaciones;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Usuario(String nombre, String apellidos, String nick, String contraseña, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nick = nick;
        this.contraseña = contraseña;
        this.email = email;
    }

    public void crearEntrada(Subforo subforo){
        
    }
    
    public void crearComentario(Usuario usuario, EntradaGenerica entrada){
        
//        if(entrada.crearEntrada()){
            //Se crea la entrada con su texto
//        } 
    }
    
    public void votarEntrada(EntradaGenerica entrada, int puntuacion){
        entrada.setPuntuacion(puntuacion);
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public void recibirNotificacion(String notificacion) {
        this.notificaciones.add(notificacion);
    }

    
}
