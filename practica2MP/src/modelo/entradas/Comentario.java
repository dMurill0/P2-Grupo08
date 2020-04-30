package modelo.entradas;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.usuario.Usuario;


public class Comentario implements Serializable{
    
    private String comentario;
    private int puntuacion;
    private ArrayList<Comentario> respuestas;
    private ArrayList<Usuario> alUsVotacion;
    private ArrayList<Boolean> alIntVotacion;
    
    
    public Comentario(String comentario){
        this.comentario = comentario;
    }
    
    public Comentario comentar(String texto){
        Comentario comentario = new Comentario(texto);
        respuestas.add(comentario);
        return comentario;
    }
    
    public boolean votar(Usuario usuario, boolean valor){
        if (alUsVotacion.contains(usuario)){
            int pos = alUsVotacion.indexOf(usuario);
            boolean esPositivo = alIntVotacion.get(pos);
            if (esPositivo==valor) return false;
            else alIntVotacion.add(pos, valor);
        } else {
            alUsVotacion.add(usuario);
            alIntVotacion.add(valor);
        }
        return true;
    }
}

