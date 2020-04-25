package modelo;

import modelo.sistema.Sistema;

public class Demostrador {

    public static void main(String[] args) {
        System.out.println("****** Práctica 2 - Grupo 8 - MP ******");
        System.out.println("Inicio del Sistema...");
        Sistema sesion = new Sistema();
        System.out.println("Sistema iniciado correctamente.");

        /* Login */
        login(sesion);
        /* Registro */
        registro(sesion);
        /* Logout */
        sesion.logout();
        /* Subforo */
        System.out.println("El usuario " + sesion.getUsuarioConectado().getNick() + " va a crear un subforo");
        if (sesion.getUsuarioConectado().getRol().equalsIgnoreCase("profesor")) {

        } else {
            System.out.println("Ha habido un error al crear el subforo. Debes ser profesor para poder crearlo");
        }

        /* Entrada */

        /* Persistencia de datos */

    }

    public static void login(Sistema sesion){
        System.out.println("Iniciamos la sesión con  usuario no registrado");
        if (sesion.login("cucu", "tras")) {
            System.out.println("Sesion iniciada correctamente " + sesion.getUsuarioConectado().getNick());
        } else {
            System.out.println("Error. Nick y/o password incorrectos");
        }
        System.out.println("Iniciamos la sesión con  usuario no registrado");
        if (sesion.login("dani", "tras")) {
            System.out.println("Sesion iniciada correctamente " + sesion.getUsuarioConectado().getNick());
        } else {
            System.out.println("Error. Nick y/o password incorrectos");
        }
    }

    public static void registro(Sistema sesion){
        System.out.println("Registro con correo no perteneciente a la URJC");
        if (sesion.registrarUsuario("Daniel", "Murillo Garzon", "cucu", "tras", "emilio@gmail.com")) {
            System.out.println("Bienvenido al Foro " + sesion.getUsuarioConectado().getNick());
        } else {
            System.out.println("El correo es erroneo.");
        }

        System.out.println("Registro con correo perteneciente a la URJC");
        if (sesion.registrarUsuario("Daniel", "Murillo Garzon", "cucu", "tras", "emilio@alumnos.urjc.es")) {
            System.out.println("Bienvenido al Foro " + sesion.getUsuarioConectado().getNick());
        } else {
            System.out.println("El correo es erroneo.");
        }
    }
}
