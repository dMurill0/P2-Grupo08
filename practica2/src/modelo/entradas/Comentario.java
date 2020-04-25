package modelo.entradas;

import java.util.ArrayList;


public class Comentario {
    
    private String comentario;
    private int puntuacion;
    private ArrayList<String> respuestas;

    public void comentar(String texto){
        this.comentario = texto;

    }
    //falta comprobar si esta logueado para poder votar
    public void votar(int valor){
        this.puntuacion=+valor;
    }
}
