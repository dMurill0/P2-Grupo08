package modelo;

import modelo.sistema.Sistema;

public class Demostrador {

    public static void main(String[] args) {
        System.out.println("****** Práctica 2 - Grupo 8 - MP ******");
        System.out.println("Inicio del Sistema...");
        Sistema sesion = new Sistema();
        System.out.println("Sistema iniciado correctamente.");
        System.out.println("Inicio de sesión con Usuario No registrado...");
        System.out.println("");
        System.out.println("");
        /*               Login                     */
        System.out.println("Iniciamos la sesión sin ningún usuario registrado");
        if (sesion.login("dani", "danilo")){
            System.out.println("Sesion iniciada correctamente "+ sesion.getUsuarioConectado().getNick());
        }
        else {
            System.out.println("Error. Nick y/o password incorrectos");
        }
        /*               Logout                     */
        sesion.logout();

        /*               Registro                     */
        System.out.println("Creación de una nueva cuenta");
        if(sesion.registrarUsuario("Daniel", "Murillo Garzon", "cucu", "tras", "emilio@gmail.com")){
            System.out.println("Bienvenido al Foro "+ sesion.getUsuarioConectado().getNick());
        }
        else{
            System.out.println("Ha habido un error al crear la cuenta.");
        }

        /*               Subforo                     */
        System.out.println("El usuario "+sesion.getUsuarioConectado().getNick()+ " va a crear un subforo");
        if(sesion.getUsuarioConectado().getRol().equalsIgnoreCase("profesor")){
            
        }
        else{
            System.out.println("Ha habido un error al crear el subforo. Debes ser profesor para poder crearlo");
        }

        /*               Entrada                     */


        /*               Persistencia de datos                     */


    }
    
}
