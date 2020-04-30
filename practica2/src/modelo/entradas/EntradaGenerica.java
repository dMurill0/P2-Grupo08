package modelo.entradas;

import java.util.ArrayList;
import modelo.usuario.Usuario;

public abstract class EntradaGenerica{
    protected String titulo;
    protected String texto;
    protected boolean verificada = false;
    protected boolean votado;
    protected int puntuacion;
    //protected int valorVoto;
    //protected HashMap<, boolean> hmap = new HashMap<>();
    
    protected ArrayList <Usuario> votoUsuarios;
    
    public EntradaGenerica(String titulo, String texto){
        this.titulo = titulo;
    }
    
    abstract public String getTitulo();
    abstract public void setTitulo(String titulo);
    abstract public String getTexto();
    abstract public void setTexto(String texto);
    abstract public boolean getVerificada();
    abstract public void setVerificada(boolean verificada);
    abstract public int getPuntuacion();
    abstract public void setPuntuacion(int puntuacion);
    abstract public void verificar(boolean resultado);
    abstract public void comentar(String texto);
    abstract public boolean votar(Usuario usuario,boolean valor);
}

