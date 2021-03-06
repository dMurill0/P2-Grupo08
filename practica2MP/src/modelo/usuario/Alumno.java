package modelo.usuario;

import java.io.Serializable;
import modelo.entradas.EntradaGenerica;
import modelo.entradas.TextoPlano;
import modelo.sistema.Penalizacion;
import modelo.sistema.Subforo;


public class Alumno extends Usuario implements Serializable{
    
    private Administrador administrador;
    private Penalizacion penaliz;

    public Penalizacion getPenaliz() {
        return penaliz;
    }

    public void setPenaliz(Penalizacion penaliz) {
        this.penaliz = penaliz;
    }
    
    public Alumno(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
        super.setRol("alumno");
        this.penaliz = new Penalizacion();
    }
    
    public boolean penalizar(int dias){
        if(this.penaliz.estaPenalizado()){
            return false;
        }else{
            this.penaliz = new Penalizacion(dias);
            return true;
        }
        
    }

    public boolean estaPenalizado(){ //comparar las fechas de inicio y fin de la clase Penalizacion con la actual
        return this.penaliz.getDiasPenalizacion() > 0;
    }  
    
    
    @Override
    public EntradaGenerica crearEntrada(Subforo subforo, String titulo, String texto){
        EntradaGenerica textoPlano = new TextoPlano(titulo, texto);
        subforo.setAlEntradas(textoPlano);
        return textoPlano;  
//        administrador.verificarEntrada(textoPlano);
//        
//        if(textoPlano.getVerificada()){
//            subforo.setAlEntradas(textoPlano);
//            System.out.println("La entrada ha sido verificada.");
//        }else{
//            System.out.println("No ha sido posible verificar la entrada.");
//        }
        
    }
}
