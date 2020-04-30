package modelo.usuario;


import java.io.Serializable;
import java.util.ArrayList;
import modelo.Suscriptor;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGenerica;
import modelo.sistema.Subforo;


public abstract class Usuario implements Suscriptor, Serializable{
    //protected Penalizacion penalizacion;
    protected Entrada entrada;
    protected String nombre;
    protected String apellidos;
    protected String nick;
    protected String contraseña;
    protected String email;
    protected String rol; //indicar en la creacion de usuario si es alumno,profesor o admin y comparar con equalsIgnoreCase
    protected ArrayList<String> notificaciones;

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
    
    /**
     *
     * @param subforo Añade la entrada creada al subforo
     * @param titulo Añade el titulo a la entrada
     * @param texto Añade el texto a la entrada
     * @return devuelve el objeto Enrada creado
     */
    public abstract EntradaGenerica crearEntrada(Subforo subforo, String titulo, String texto);
    
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

    public void mostrarNotificaciones(){
        if(notificaciones != null){
            for(int i = 0;i<notificaciones.size();i++){
                System.out.println(notificaciones.get(i));
            }
        }
    }
    @Override
    public void recibirNotificacion(String notificacion) {
        this.notificaciones.add(notificacion);
    }
}
