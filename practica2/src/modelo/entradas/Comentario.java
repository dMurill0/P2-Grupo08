package modelo.entradas;

import java.util.ArrayList;
import modelo.usuario.Usuario;


public class Comentario {
    
    private String comentario;
    private int puntuacion;
    private ArrayList<Comentario> respuestas;
    
    public Comentario(String comentario){
        this.comentario = comentario;
    }
    
    public Comentario comentar(String texto){
        Comentario comentario = new Comentario(texto);
        this.respuestas.add(comentario);
        return comentario;
    }
}

    //falta comprobar si esta logueado para poder votar

    public boolean votar(Usuario usuario, boolean valor, int votado){
        if(!this.votado){//Si votado es igual a null
            super.votoUsuarios.add(usuario);
            this.votado = valor;//Si el valor que recibe es true es voto positivo y viceversa
            return true;
        }else{
            if(this.votado == valor){
                //Esto es cuando ha vuelto a votar lo mismo
                return false;
            }else{
                //Esto para cuando se cambia de positivo a negativo o viceversa
                    this.votado = valor;
                    super.votoUsuarios.add(usuario);
                    return true;
                }
        }
    }

