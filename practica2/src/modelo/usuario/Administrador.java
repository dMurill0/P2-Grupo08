package modelo.usuario;

import modelo.entradas.Comentario;
import modelo.entradas.EntradaGenerica;
import modelo.sistema.Subforo;


public class Administrador extends Usuario{

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
        
        entrada.verificar(true);
        
        return true;
    }

    @Override
    public EntradaGenerica crearEntrada(Subforo subforo, String titulo, String texto) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Comentario crearComentario(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

