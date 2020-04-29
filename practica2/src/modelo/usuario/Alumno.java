package modelo.usuario;

import java.util.Calendar;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGenerica;
import modelo.entradas.TextoPlano;
import modelo.sistema.Penalizacion;
import modelo.sistema.Subforo;


public class Alumno extends Usuario{
    private Administrador administrador;
    private Penalizacion penalizacion;
    private boolean tienePenalizacion;
    
    public Alumno(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
        super.setRol("alumno");
    }

    public boolean estaPenalizado(){ //comparar las fechas de inicio y fin de la clase Penalizacion con la actual     
        if(penalizacion.getFechaInicio().compareTo(penalizacion.getFechaFinalizacion()) < 0){
            return (this.tienePenalizacion = false);
        }else{
            return (this.tienePenalizacion = true);
        }
    }  
    
    
    public void crearEntrada(Subforo subforo, String titulo, String texto){
        EntradaGenerica textoPlano = new TextoPlano(titulo, texto);
        
        System.out.println("Verificando entrada...");
        administrador.verificarEntrada(textoPlano);
        
        if(textoPlano.getVerificada()){
            subforo.setAlEntradas(textoPlano);
            System.out.println("La entrada ha sido verificada.");
        }else{
            System.out.println("No ha sido posible verificar la entrada.");
        }
    }
}
