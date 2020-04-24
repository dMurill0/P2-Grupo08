package modelo.entradas;

public class Entrada extends EntradaGenerica{
    
    public Entrada(String titulo, String texto){
        super(titulo, texto);
    }
    
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getTexto(){
        return texto;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    @Override
    public int getPuntuacion(){
        return puntuacion;
    }
    @Override
    public void setPuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }
    @Override
    public void verificar(boolean resultado){
        
    }
    @Override
    public boolean comentar(String texto){
        return true;
    }
    @Override
    public boolean votar(int valor){
        return true;
    }
}
