package modelo;

public abstract class EntradaGenerica{
    protected int puntuacion;
    protected String titulo;
    protected String texto;
    protected boolean verificada;
    
    public EntradaGenerica(String titulo, String texto){
        this.titulo = titulo;
        this.texto = texto;
    }
    
    abstract public int getPuntuacion();
    abstract public void setPuntuacion(int puntuacion);
    abstract public void verificar(boolean resultado);
    abstract public boolean comentar(String texto);
    abstract public boolean votar(int valor);
}

