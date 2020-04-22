package modelo;

public class Profesor extends Usuario{

    public Profesor(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
    }
    
    public void crearEncuesta(){
        Encuesta encuesta = new Encuesta();
    }

    public void crearEjercicio(){
        Ejercicio ejercicio = new Ejercicio();
    }

}
