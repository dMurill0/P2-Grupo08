
import java.util.ArrayList;

public class Sistema {
    private static Sistema sistema;
    private Usuario usuarioConectado;
    
    private ArrayList<Subforo> alSubforos;
    private ArrayList<Usuario> alUsuarios;
    
    //??
    public Sistema (){
        
    }
    
    //???
    public static Sistema getSistema(){
        return Sistema.sistema;
    }
    
    public Usuario getUsuarioConectado(){
        return usuarioConectado;
    }
    
    public boolean login(String nick, String password){
        if (esUsuarioRegistrado(nick, password))
            return true;
        else return false;
    }
    
    //???
    private boolean esUsuarioRegistrado(String nick, String password){
        //Comprobar en la BD
    }
    
    public boolean logout(){
        if (usuarioConectado!=null){
            usuarioConectado=null;
            return true;
        } else {
            return false;
        }
    }
    
    //???
    public static Sistema cargarSistema(){
        
    }
    
    //???
    private boolean guardarSistema(){
        
    }
    
    //???
    public boolean registrarUsuario(String nombre, String apellidos, String password, String email){
        Usuario usuario = new Usuario(nombre, apellidos, password, email);
        //Almacenar en la BD
        if (anadirUsuario(usuario)) return true;
        else return false;
    }
    
    //???
    public ArrayList<Entrada> getEntradasMasVotadas(){
        ArrayList<Entrada> alEntradasMasVotadas = null;
        //Consultar en la BD
        
        return alEntradasMasVotadas;
    }
    
    //???
    public boolean crearSubForo(String titulo){
        Subforo subforo = new Subforo(titulo);
        //Consultar en la BD
        if (anadirSubforo(subforo)) return true;
        else return false;
    }
}
