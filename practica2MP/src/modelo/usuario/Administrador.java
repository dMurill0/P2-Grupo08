package modelo.usuario;

import java.io.Serializable;
import modelo.entradas.EntradaGenerica;
import modelo.sistema.Subforo;


public class Administrador extends Usuario implements Serializable{

    public Administrador(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
    }
    
    //establecer fecha de la penalizacion y sumarle dos dia(fin del ban) luego comparar esa fecha en estaPenalizado
    public void penalizar(Usuario usuario, int diasPenalizacion){  
        if(usuario instanceof Alumno){
            ((Alumno) usuario).penalizar(diasPenalizacion);
        }
    }
    
    //Este metodo simplemente verifica la entrada
    public boolean verificarEntrada(EntradaGenerica entrada){
        if(entrada != null){
            entrada.verificar(true);
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public EntradaGenerica crearEntrada(Subforo subforo, String titulo, String texto) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}

