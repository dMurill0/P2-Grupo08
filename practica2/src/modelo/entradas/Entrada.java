package modelo.entradas;

import modelo.sistema.Subforo;
import modelo.usuario.Administrador;
import modelo.usuario.Usuario;

public class Entrada extends EntradaGenerica{
    
    Administrador administrador;
    public void crearEntrada(Subforo subforo, String titulo, String texto){
        
        Entrada entrada = new Entrada(titulo,texto);
        
        boolean publicar = administrador.verificarEntrada(entrada);
        
    }
    
    public Entrada(String titulo, String texto){
        super(titulo, texto);
    }
    
    @Override
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    @Override
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
        super.verificada = resultado;
    }
    @Override
    public boolean comentar(String texto){
        return true;
    }
    @Override
    public boolean votar(Usuario usuario, int valor){
        super.VotoUsuarios.add(usuario);
        return true;
    }

    @Override
    public boolean getVerificada() {
        return this.verificada;
    }
}
