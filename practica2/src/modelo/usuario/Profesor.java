package modelo.usuario;

import modelo.entradas.Ejercicio;
import modelo.entradas.Encuesta;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGenerica;
import modelo.entradas.TextoPlano;
import modelo.sistema.Subforo;

public class Profesor extends Usuario {
    
    private Administrador administrador;

    public Profesor(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
        super.setRol("profesor");
    }
    
    public void crearEncuesta(Subforo subforo, String titulo, String texto){
        EntradaGenerica encuesta = new Encuesta(titulo,texto);
        administrador.verificarEntrada(encuesta); 
    }

    public void crearEjercicio(Subforo subforo, String titulo, String texto){
        EntradaGenerica ejercicio = new Ejercicio(titulo,texto);
        administrador.verificarEntrada(ejercicio);
    }
    
    public void crearTextoPlano(Subforo subforo, String titulo, String texto){
        EntradaGenerica textoPlano = new TextoPlano(titulo,texto);
        administrador.verificarEntrada(textoPlano);
    }
    
    public Subforo crearSubfboro(String nombre){
        Subforo subforo = new Subforo(nombre);
        
        return subforo;
    }
    
    public void crearEntrada(Subforo subforo, String titulo, String texto){
        
        EntradaGenerica entrada = new Entrada(titulo, texto);
        
        System.out.println("Verificando entrada...");
        administrador.verificarEntrada(entrada);
        
        if(entrada.getVerificada()){
            subforo.setAlEntradas(entrada);
            System.out.println("La entrada ha sido verificada.");
        }else{
            System.out.println("No ha sido posible verificar la entrada.");
        }
    }

    @Override
    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearEntrada(Subforo subforo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearComentario(Usuario usuario, EntradaGenerica entrada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void votarEntrada(EntradaGenerica entrada, int puntuacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNick(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(String contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRol() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRol(String rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirNotificacion(String notificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
