package modelo.sistema;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import modelo.usuario.Alumno;
import modelo.usuario.Profesor;

import modelo.usuario.Usuario;

public class Sistema implements Serializable{
    private static final String NOMBRE_BD = "P2_Grupo8_BD.mp";
    private static Sistema sistema;
    private Usuario usuarioConectado;
    
    private static ArrayList<Subforo> alSubforos;
    private static ArrayList<Usuario> alUsuarios;
    
    /**
     * CONSTRUCTOR. Inicializa ArrayList<Usuario> y ArrayList<Subforo>
     */
    public Sistema (){
        alUsuarios = new ArrayList<Usuario>();
        alSubforos = new ArrayList<Subforo>();
    }
    
    /**
     * Comprueba si el usuario recibido existe en la BD y coinciden sus credenciales.
     * 
     * @param nick Nick del usuario a iniciar sesión.
     * @param password Contraseña del usuario a iniciar sesión.
     * @return Devuelve True si todo ha ido correctamente, False en caso contrario.
     */
    public boolean login(String nick, String password){
        for (Usuario usuario : alUsuarios){
            if ((usuario.getNick().equals(nick)) && (usuario.getPassword().equals(password))){
                usuarioConectado = usuario;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Permite cerrar sesión al usuario logeado.
     * 
     * @return Devuelve True si se cerró sesión correctamente. En caso de que el 
     *  usuario no hubiese iniciado sesión, devolverá True, dado que el resultado
     *  final es que no haya ningún usuario con la sesión iniciada.
     */
    public boolean logout(){
        if (usuarioConectado!=null)
            usuarioConectado=null;
         return true;
    }
    
    /**
     * Permite recuperar la información de la BD.
     * 
     * @return Devuelve 
     */
    public static Sistema cargarSistema(){
        try{
            FileInputStream fis = new FileInputStream(NOMBRE_BD);
            ObjectInputStream ois = new ObjectInputStream(fis);
            sistema = (Sistema) ois.readObject();
            //alUsuarios = sistema.getUsuarios();
            //alSubforos = sistema.getSubforos();
            
            ois.close();
            fis.close();
            return sistema;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    /**
     * Permite almacenar la información en la BD
     * 
     * @return Devuelve True si todo ha ido correctamente, False en caso contrario
     */
    private boolean guardarSistema(){
        try {
            FileOutputStream fos = new FileOutputStream(NOMBRE_BD);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sistema);
            oos.close();
            fos.close();
            System.out.println("Datos guardados correctamente");
            return true;
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    /**
     * Permite añadir un nuevo usuario a la BD.
     * 
     * @param nombre Nombre del usuario a añadir.
     * @param apellidos Apellidos del usuario a añadir.
     * @param nick Nick del usuario a añadir.
     * @param password Contraseá del usuario a añadir.
     * @param email Email del usuario a añadir.
     * @return Devuelve True si el registro se realizó correctamente, False en
     *  caso contrario.
     */
    public int registrarUsuario(String nombre, String apellidos, String nick, 
            String password, String email){
        int aux = perteneceURJC(email);
        if (aux==0){
            Alumno alumno = new Alumno(nombre, apellidos, nick, password, email);
            alUsuarios.add(alumno);
            guardarSistema();
            return 0;
        } else if (aux==1){
            Profesor profesor = new Profesor(nombre, apellidos, nick, password, email);
            alUsuarios.add(profesor);
            guardarSistema();
            return 1;
        } else {
            return -1;
        }
    }
    
    /**
     * Permite saber si el usuario a registrarse pertenece a la URJC.
     * Esta comprobación se realiza a partir del correo electrónico.
     * 
     * @param email Email a comprobar.
     * @return Devuelve True si el correo pertenece a la URJC.
     */
    public int perteneceURJC(String email){
        //Dado que no se tiene acceso a la BD de la URJC, la comprobación se hará
        //  a partir del dominio del correo.
        if (email.contains("@alumnos.urjc.es")) { return 0; }
        else if (email.contains("@urjc.es")) { return 1; }
        else return -1;
    }
    
    //???
   /*  public ArrayList<Entrada> getEntradasMasVotadas(){
        ArrayList<Entrada> alEntradasMasVotadas = null;
        //Consultar en la BD
        
        
        return alEntradasMasVotadas;
    } */
    
    /**
     * Permite crear un Subforo nuevo y añadirlo a la BD.
     * 
     * @param titulo Nombre del subforo.
     * @return Devuelve True si la operación se realizó correctamente, False en
     *  caso contrario.
     */
    public boolean crearSubforo(String titulo){
        Subforo subforo = new Subforo(titulo);
        alSubforos.add(subforo);
        guardarSistema();
        return true;
    }
    
    /************* Getters and Setter *************/
    /**
     * Devuelve la instancia estática de Sistema.
     * 
     * @return Instancia estática Sistema.
     */
    public static Sistema getSistema(){
        if (sistema==null) sistema = new Sistema();
        return sistema;        
    }
    
    /**
     * Devuelve el usuario conectado actualmente.
     * 
     * @return Usuario conectado actualmente.
     */
    public Usuario getUsuarioConectado(){
        return usuarioConectado;
    }
}