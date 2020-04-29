package modelo.usuario;

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
    public void verificarEntrada(EntradaGenerica entrada){
        
        entrada.verificar(true);
        
//        Scanner myObj = new Scanner(System.in);
//        System.out.println("¿Desea verificar la entrada? Y/N");
//        String input = myObj.nextLine();
//        if(input.equals("Y")){
//            entrada.verificar(true);
//            System.out.println("Titulo: "+ entrada.getTitulo());
//            System.out.println("Texto : "+ entrada.getTexto());
//        }else{            
//            entrada.verificar(false);
//        }
//        return input.equals("Y"); 
    }

    @Override
    public void crearEntrada(Subforo subforo, String titulo, String texto) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}

