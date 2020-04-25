package modelo.usuario;

import java.util.Scanner;
import modelo.entradas.EntradaGenerica;


public class Administrador extends Usuario{

    public Administrador(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
    }
    
    public boolean verificarEntrada(EntradaGenerica entrada){
        Scanner myObj = new Scanner(System.in);
        System.out.println("¿Desea verificar la entrada? Y/N");
        System.out.println("Titulo: "+ entrada.getTitulo());
        System.out.println("Texto : "+ entrada.getTexto());
        
        String input = myObj.nextLine();
        
        return input.equals("Y"); 
    }
    
}
