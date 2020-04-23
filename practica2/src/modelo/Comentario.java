package modelo;


public class Comentario {
    
    private String comentario;
    private int puntuacion;

    public void comentar(String texto){
        this.comentario = texto;

    }
    //falta comprobar si esta logueado para poder votar
    public void votar(int valor){
        this.puntuacion=+valor;
    }
}
