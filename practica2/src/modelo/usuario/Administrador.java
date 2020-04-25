package modelo.usuario;

import modelo.entradas.EntradaGenerica;


public class Administrador extends Usuario{

    public Administrador(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
    }
    
    public boolean verificarEntrada(EntradaGenerica entrada){
        System.out.println("¿Desea verificar la entrada?");
        System.out.println("Titulo: "+ entrada.getTitulo());
        System.out.println("Texto : "+ entrada.getTexto());
        //Input
        String input = "yes";
        if(input == "yes"){
            return true;
        }else{
            return false;
        }
    }
}
