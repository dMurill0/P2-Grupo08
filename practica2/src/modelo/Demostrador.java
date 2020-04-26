package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import modelo.entradas.Comentario;
import modelo.entradas.Entrada;
import modelo.sistema.Sistema;
import modelo.sistema.Subforo;
import modelo.usuario.Administrador;
import modelo.usuario.Alumno;
import modelo.usuario.Profesor;
import modelo.usuario.Usuario;

public class Demostrador {

    public static void main(String[] args) {
        System.out.println("****** Práctica 2 - Grupo 8 - MP ******");
        System.out.println("Inicio del Sistema...");
        Sistema sesion = new Sistema();
        System.out.println("Sistema iniciado correctamente.");

        /* Login */
        login(sesion);

       
        /* Subforo */
        System.out.println("El usuario " + sesion.getUsuarioConectado().getNick() + " va a crear un subforo");
        if (sesion.getUsuarioConectado().getRol().equalsIgnoreCase("profesor")) {

        } else {
            System.out.println("Ha habido un error al crear el subforo. Debes ser profesor para poder crearlo");
        }

        /* Entrada */
        System.out.println("Mostrar entradas mas votadas");
        ArrayList<Entrada> listaEntradas = sesion.getEntradasMasVotadas();
        int cont = 1;
        for (Entrada entrada : listaEntradas) {
            System.out.println("Entrada " + cont);
            System.out.println("Titulo: " + entrada.getTitulo());
            System.out.println("Puntuacion: " + entrada.getPuntuacion());
            cont++;
        }

        /* Persistencia de datos */
        Usuario usuario = sesion.getUsuarioConectado();

        if(usuario instanceof Profesor){
            System.out.println("Se va a crear un subforo");
            Subforo subforo = sesion.crearSubforo("Subforo ejemplo");
            System.out.println("Se crea un subforo");
            System.out.println("Se anade un subscriptor al subforo");
            subforo.anadirSubscriptor(usuario);
        }else{
            System.out.println("No le es permitido crear un subforo caballero");
        }

        System.out.println("Se va a crear una nueva entrada");
        Entrada entrada = usuario.crearEntrada(subforo, entrada);

        System.out.println("No es posible mostrar la entrada hasta que verifique la entrada");
        System.out.println("El administrador esta verificando la entrada");
        

        Usuario usuario2; //new Ususario(...)

        System.out.println("Otro usuario puntua la entrada positivamente");
        entrada.setPuntuacion(1);
        System.out.println("El mismo usuario puntua la entrada negativamente");
        entrada.setPuntuacion(-1);
        /*
        * @TODO
        */

        System.out.println("El usuario comenta una entrada");
        System.out.println("El administrador esta comprobando el contenido del comentario");

        Comentario comentario = entrada.comentar("texto comentario");
        Administrador admin;
        if(admin.isComentarioMalo(comentario)){ //devuelve true si el admin le apetece penalizarlo
            System.out.println("El contenido del comentario es inapropiado para la comunity");
            System.out.println("El administrador sanciona al usuario");
        }else{ //devuelve false si el admin le apetece no penalizarlo
            System.out.println("El contenido del comentario es valido");
            System.out.println("El administrador aprueba el comentario");
        }
        
        System.out.println("Otro usuario responde a otro comentario");
        
        Comentario subComentario = entrada.comentar("texto subComentario");
        if(admin.isComentarioMalo(subComentario)){ //devuelve true si el admin le apetece penalizarlo
            System.out.println("El contenido del comentario es inapropiado para la comunity");
            System.out.println("El administrador sanciona al usuario");
        }else{ //devuelve false si el admin le apetece no penalizarlo
            System.out.println("El contenido del comentario es valido");
            System.out.println("El administrador aprueba el comentario");
        }

        System.out.println("Un usuario puntua un comentario positivamente");
        comentario.setPuntuacion(usuario2); // SE METERIA EN LA LISTA DE USUARIOS QUE LE HAN DAO LIKE
        System.out.println("El mismo usuario puntua un comentario negativamente");
        comentario.setPuntuacion(usuario2); // SE SALDRIA DE LA LISTA DE USUARIOS QUE LE HAN DAO LIKE
//ok















         /* Logout */
         sesion.logout();
    }

    public static void login(Sistema sesion){
        System.out.println("Iniciamos la sesión con  usuario no registrado");
        if (sesion.login("cucu", "tras")) {
            System.out.println("Sesion iniciada correctamente " + sesion.getUsuarioConectado().getNick());
        } else {
            System.out.println("Error. Nick y/o password incorrectos o el usuario esta sancionado");
        }
        

        System.out.println("Registro con correo no perteneciente a la URJC");
        if (sesion.registrarUsuario("Margarita", "GJimenez", "margui", "123", "margi@gmail.es")) {
            System.out.println("Bienvenido al Foro " + sesion.getUsuarioConectado().getNick());
        } else {
            System.out.println("El correo es erroneo.");
        }

        System.out.println("Registro con correo perteneciente a la URJC");
        if (sesion.registrarUsuario("Margarita", "GJimenez", "margui", "123", "margi@urjc.es")) {
            System.out.println("Bienvenido al Foro Profesor " + sesion.getUsuarioConectado().getNick());
        } else {
            System.out.println("El correo es erroneo.");
        }

        System.out.println("Iniciamos sesion con el usuario");
        if(sesion.login("magui","123")){
            System.out.println("Usuario inicio sesion satisfactoriamente");
        }else{
            System.out.println("Error de credenciales");
        }
    }
}
