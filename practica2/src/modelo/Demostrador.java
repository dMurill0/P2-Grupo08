package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import modelo.entradas.Comentario;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGenerica;
import modelo.sistema.Sistema;
import modelo.sistema.Subforo;
import modelo.usuario.Administrador;
import modelo.usuario.Alumno;
import modelo.usuario.Profesor;
import modelo.usuario.Usuario;

public class Demostrador {
    private static Sistema sistema;

    public static void main(String[] args) {
        System.out.println("****** Práctica 2 - Grupo 8 - MP ******");
        System.out.println("Inicio del Sistema...");
        Sistema.cargarSistema();
        sistema = Sistema.getSistema();
        System.out.println("El sistema se cargó correctamente.");

        /* Registro y Loggin */
        login();
        
        /* Ver entradas más valoradas */
        entradasMasVotadas();
        
        /* Creación de Subforo */
        Subforo subforo = creacionSubforo();
        
        /* Crear entrada (Se gestiona el tipo: TextoPlano, Encuesta y Ejercicios)*/
        Entrada entrada = creacionEntrada(subforo);

        /* Comentar Entrada y votar */
        votarEntrada(entrada);
        Comentario comentario = comentarEntrada(entrada);
        
        /* Comentar Comentario y votar */
        Comentario comentario1 = comentarComentario(comentario);
        votarComentario(comentario1);
        
        /* Subscribirse a un Subforo */
        altaSubforo(subforo);
        
        /* Darse de baja de un Subforo */
        bajaSubforo(subforo);

        /* Logout */
        logout();
         
        /* Comprobar Persistencia */
        comprobarPersistencia();
    }

    private static void login(){
        System.out.println("Iniciamos la sesión con usuario no registrado");
        if (sistema.login("Margui", "123")) {
            System.out.println("Sesion iniciada correctamente " + sistema.getUsuarioConectado().getNick());
        } else {
            System.out.println("Error. Nick y/o password incorrectos.");
        }  

        System.out.println("Registro con correo no perteneciente a la URJC");
        if (sistema.registrarUsuario("Margarita", "GJimenez", "Margui", "123", "margi@gmail.es")) {
            System.out.println("El usuario se registró correctamente");
        } else {
            System.out.println("El correo es erroneo.");
        }

        System.out.println("Registro con correo perteneciente a la URJC");
        if (sistema.registrarUsuario("Margarita", "GJimenez", "Margui", "123", "margi@urjc.es")) {
            System.out.println("El usuario se registró correctamente");
        } else {
            System.out.println("El correo es erroneo.");
        }
        
        System.out.println("Registro con un usuario Alumno para futuras pruebas.");
        if (sistema.registrarUsuario("Alumno1", "Apellidos1", "Nick1", "123", "alumno1@alumnos.urjc.es")){
            System.out.println("El usuario se registró correctamente");
        } else {
            System.out.println("El correo es erroneo.");
        }

        System.out.println("Iniciamos sesion con el usuario Profesor.");
        if(sistema.login("Margui","123")){
            System.out.println("El usuario " + sistema.getUsuarioConectado().getNick() + " inició sesión.");
        }else{
            System.out.println("Error de credenciales");
        }
    }
    
    private static void logout(){
        System.out.println("El usuario procederá a cerrar sesión.");
        if (sistema.logout()){
            System.out.println("El usuario cerro sesión correctamente.");
            System.out.println("Los datos del Sistema se guardaron correctamente");
        } else {
            System.out.println("Error inesperado. Usuario no encontrado");
        }
    }
    
    private static void entradasMasVotadas(){
        System.out.println("Se mostrarán las entradas más valoradas haya un usuario registrado o no:");
        if (sistema.getUsuarioConectado()==null || sistema.getUsuarioConectado()!=null){
            ArrayList<Entrada> alEntradas = sistema.getEntradasMasVotadas();
            int c = 1;
            for (Entrada entrada : alEntradas){
                System.out.println("**Entrada: " + c);
                System.out.println("**Titulo: " + entrada.getTitulo());
                System.out.println("**Puntuación: " + entrada.getPuntuacion());
            }
        }
    }
    
    private static Subforo creacionSubforo(){
        Subforo subforo = null;
        System.out.println("Se crea un subforo.");
        System.out.println("Se intenta crear un subforo con un usuario Alumno.");
        logout();
        sistema.login("Nick1", "123");
        Usuario usuario = sistema.getUsuarioConectado();
        if (usuario instanceof Alumno) {
            System.out.println("El subforo no se puede crear por un Alumno.");
        }
        
        System.out.println("Se intenta crear un subforo con un usuario Profesor.");
        logout();
        sistema.login("Margui", "123");
        Usuario usuario = sistema.getUsuarioConectado();
        if (usuario instanceof Profesor) {
            subforo = sistema.crearSubforo("Subforo1");
            System.out.println("El subforo se creó correctamente.");
        }
        return subforo;
    }
    
    private static Entrada creacionEntrada(Subforo subforo){
        Entrada entrada = null;
        System.out.println("Se intenta crear una entrada sin haber iniciado sesión");
        logout();
        Usuario usuario = sistema.getUsuarioConectado();
        if (usuario != null){
            entrada = usuario.crearEntrada(subforo, "Titulo1", "Texto1");
            System.out.println("La entrada se creó correctamente.");
            notificarUsuarios(subforo);
        } else {
            System.out.println("Se necesita iniciaro sesión para crear una entrada.");
        }
        
        System.out.println("Se crea con el usuario registrado.");
        sistema.login("Margui", "123");
        usuario = sistema.getUsuarioConectado();
        if (usuario != null){
            entrada = usuario.crearEntrada(subforo, "Titulo1", "Texto1");
            System.out.println("La entrada se creó correctamente.");
            notificarUsuarios(subforo);
        } else {
            System.out.println("Se necesita iniciaro sesión para crear una entrada.");
        }
        
        System.out.println("El administrador va a verificar la entrada.");
        Administrador administrador = new Administrador("Administrador1", "Apellidos1", "Admin", "1234", "administrador@urjc.es");
        if (administrador instanceof Administrador){
            if (administrador.verificarEntrada(entrada)){
                System.out.println("El administrador verificó la entrada y se publicó");
            } else {
                System.out.println("El administrador detectó un mensaje indebido.");
                administrador.penalizar(usuario,2);
                System.out.println("El administrador penalizó al usuario.");
            }
        }
    }
    
    private static void notificarUsuarios(Subforo subforo){
        System.out.println("Al crear una nueva entrada, se notifica a los usuarios suscritos al subforo");
        subforo.notificar();
    }
    
    private static Comentario comentarEntrada(Entrada entrada){
        Comentario comentario = null;
        System.out.println("Se comentará la entrada si está visible.");
        if (entrada.getVerificada()){
            comentario = entrada.comentar("TextoComentario");
            System.out.println("La entrada se comentó correctmanete.");           
        } else {
            System.out.println("La entrada no está verificada.");
        }
        
        return comentario;
    }
    
    private static Comentario comentarComentario(Comentario comentario){
        Comentario comentario1 = null;
        System.out.println("Se va a comentar el comentario anterior");
        if (comentario!=null){
            comentario1 = comentario.comentar("Comentario del comentario");
            System.out.println("El comentario se comentó correctmanete.");
        } else {
            System.out.println("El comentario no existe.");
        }
        
        return comentario1;
    }
    
    private static void votarEntrada(Entrada entrada){
        System.out.println("Se va a votar la entrada anterior");
        if(entrada!=null && entrada.getVerificada()){
            boolean votoPositivo = true;
            if (entrada.votar(sistema.getUsuarioConectado(), votoPositivo)){
                System.out.print("La entrada se votó correctamente.");
                if (votoPositivo) System.out.println("Voto positivo.");
                else System.out.println("Voto negativo.");
            } else {
                System.out.println("ERROR. La entrada ya ha sido con el mismo voto.");
            }
        } else {
            System.out.println("La entrada no existe o no está verificada.");
        }
    }
    
    private static void votarComentario(Comentario comentario){
        System.out.println("Se votará el comentario anterior.");
        if (comentario!=null){
            boolean votoPositivo = false;
            if (comentario.votar(sistema.getUsuarioConectado(), votoPositivo)){
                System.out.print("El comentario se votó correctamente.");
                if (votoPositivo) System.out.println("Voto positivo.");
                else System.out.println("Voto negativo.");
            } else {
                System.out.println("ERROR. El comentario ya ha sido con el mismo voto.");
            }
        } else {
            System.out.println("El comentario no existe.");
        }
    }
    
    private static void altaSubforo(Subforo subforo){
        System.out.println("Se dará de alta el usuario en el subforo.");
        if (subforo.anadirSubscriptor(sistema.getUsuarioConectado())){
            System.out.println("El usuario se ha subscrito al subforo correctamente.");
        } else {
            System.out.println("ERROR. El usuario no se pudo subscribir en el subforo.");
        }
    }
    
    private static void bajaSubforo(Subforo subforo){
        System.out.println("Se dará de baja el usuario en el subforo.");
        if (subforo.eliminarSubscriptor(sistema.getUsuarioConectado())){
            System.out.println("El usuario se ha dado de baja en el subforo correctamente.");
        } else {
            System.out.println("ERROR. El usuario no se pudo dar de baja en el subforo.");
        }
    }
    
    private static void comprobarPersistencia(){
        System.out.println("Se vuelve a iniciar el sistema para comprobar la persistencie de los datos.");
        System.out.println("Al cargar el Sistema nuevamnete, se sobreescribirán los datos.");
        System.out.println("---------");
        System.out.println("Inicio del Sistema...");
        Sistema.cargarSistema();
        sistema = Sistema.getSistema();
        System.out.println("El sistema se cargó correctamente.");
        System.out.println("Se mostrarán algunos datos almacenados anteriormente:");
        System.out.println("*USUARIOS: ");
        for (Usuario aux : sistema.getUsuarios()){
            System.out.println("Email: " + aux.getEmail() + " -- NICK: " + aux.getNick());
        }
        System.out.println();
        System.out.println("*SUBFOROS: ");
        for (Subforo aux : sistema.getSubforos()){
            System.out.println("Titulo: " + aux.getTitulo());
            for (EntradaGenerica auxEntrada : aux.getAlEntradas()){
                System.out.println("**Entrada: " + auxEntrada.getTitulo() + " -- " + auxEntrada.getPuntuacion());
            }
        }
    }
}
