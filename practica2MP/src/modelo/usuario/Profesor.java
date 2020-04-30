package modelo.usuario;

import java.io.Serializable;
import modelo.entradas.Ejercicio;
import modelo.entradas.Encuesta;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGenerica;
import modelo.entradas.TextoPlano;
import modelo.sistema.Subforo;

public class Profesor extends Usuario implements Serializable{
    
    private Administrador administrador;

    public Profesor(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
        super.setRol("profesor");
    }
    
    public void crearEncuesta(Subforo subforo, String titulo, String texto){
        EntradaGenerica encuesta = new Encuesta(titulo,texto);
        administrador.verificarEntrada(encuesta); 
    }

    public void crearEjercicio(Subforo subforo, String titulo, String texto){
        EntradaGenerica ejercicio = new Ejercicio(titulo,texto);
        administrador.verificarEntrada(ejercicio);
    }
    
    public void crearTextoPlano(Subforo subforo, String titulo, String texto){
        EntradaGenerica textoPlano = new TextoPlano(titulo,texto);
        administrador.verificarEntrada(textoPlano);
    }
    
    public Subforo crearSubfboro(String nombre){
        Subforo subforo = new Subforo(nombre);
        
        return subforo;
    }
    
    @Override
    public EntradaGenerica crearEntrada(Subforo subforo, String titulo, String texto){
        
        EntradaGenerica entrada1 = new Entrada(titulo, texto);
        subforo.setAlEntradas(entrada1);
        return entrada1;
        
//        System.out.println("Verificando entrada...");
//        administrador.verificarEntrada(entrada1);
//        
//        if(entrada1.getVerificada()){
//            subforo.setAlEntradas(entrada1);
//            System.out.println("La entrada ha sido verificada.");
//        }else{
//            System.out.println("No ha sido posible verificar la entrada.");
//        }

    }
}
