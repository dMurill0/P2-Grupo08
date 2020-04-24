package modelo.usuario;

import modelo.entradas.Ejercicio;
import modelo.entradas.Encuesta;

public class Profesor extends Usuario {

    public Profesor(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
    }
    
    public void crearEncuesta(String titulo, String texto){
        Encuesta encuesta = new Encuesta(titulo,texto);
    }

    public void crearEjercicio(String titulo, String texto){
        Ejercicio ejercicio = new Ejercicio(titulo,texto);
    }

}
