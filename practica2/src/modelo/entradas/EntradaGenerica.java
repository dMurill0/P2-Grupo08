package modelo.entradas;

import java.util.ArrayList;
import modelo.usuario.Usuario;

public abstract class EntradaGenerica{
    protected int puntuacion;
    protected String titulo;
    protected String texto;
    protected boolean verificada;
    //protected HashMap<, boolean> hmap = new HashMap<>();
    
    protected ArrayList <Usuario> VotoUsuarios;
    
    public EntradaGenerica(String titulo, String texto){
        this.titulo = titulo;
        this.texto = texto;
    }
    
    abstract public String getTitulo();
    abstract public String getTexto();
    abstract public boolean getVerificada();
    abstract public int getPuntuacion();
    abstract public void setPuntuacion(int puntuacion);
    abstract public void verificar(boolean resultado);
    abstract public boolean comentar(String texto);
    abstract public boolean votar(Usuario usuario,int valor);
}

