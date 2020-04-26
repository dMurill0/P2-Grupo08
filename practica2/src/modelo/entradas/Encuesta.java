package modelo.entradas;

import java.util.ArrayList;
import modelo.usuario.Usuario;

public class Encuesta extends EntradaGenerica{
    private ArrayList<String> respuestas;

    public Encuesta(String titulo, String texto){
        super(titulo, texto);
    }
    
        @Override
    public String getTitulo(){
        return titulo;
    }
    @Override
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    @Override
    public String getTexto(){
        return texto;
    }
    @Override
    public void setTexto(String texto){
        this.texto = texto;
    }
    @Override
    public boolean getVerificada() {
        return this.verificada;
    }
    @Override
    public void setVerificada(boolean verificada){
        this.verificada = verificada;
    }
    @Override
    public int getPuntuacion(){
        return this.puntuacion;
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
        this.texto = texto;
        return true;
    }
    @Override
    public boolean votar(Usuario usuario, boolean valor){
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
}