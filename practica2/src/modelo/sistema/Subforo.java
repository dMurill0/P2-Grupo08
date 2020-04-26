package modelo.sistema;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.entradas.Entrada;
import modelo.entradas.EntradaGenerica;
import modelo.usuario.Usuario;

public class Subforo implements Subject, Serializable {
    private String titulo;
    private ArrayList<Usuario> alUsuarios;
    private ArrayList<EntradaGenerica> alEntradas;

    public Subforo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Usuario> getAlUsuarios() {
        return alUsuarios;
    }

    public void setAlUsuarios(ArrayList<Usuario> alUsuarios) {
        this.alUsuarios = alUsuarios;
    }

    public ArrayList<EntradaGenerica> getAlEntradas() {
        return alEntradas;
    }
    //Este metodo no deberia hacer un append al array de entradas????
    public void setAlEntradas(EntradaGenerica entrada){
        this.alEntradas.add(entrada);
    }
    
    
    @Override
    public boolean anadirSubscriptor(Usuario subs) {
        boolean añadido = false;
        for (int i = 0; i < this.alUsuarios.size(); i++) {
            if (this.alUsuarios.get(i).getNick() == subs.getNick()) {
                System.out.println("Este usuario ya es un subscriptor");
                añadido = false;
            } else {
                alUsuarios.add(subs);
                añadido = true;
            }
        }
        return añadido;
        // Sistema aux = Sistema.getSistema();
    }

    @Override
    public boolean eliminarSubscriptor(Usuario subs) {
        boolean borrar = false;
        for (int i = 0; i < this.alUsuarios.size(); i++) {
            if (this.alUsuarios.get(i).getNick() == subs.getNick()) {
                System.out.println("Subscriptor eliminado");
                borrar = true;
            } else {
                alUsuarios.remove(subs);
                System.out.println("Este usuario no era un subscriptor");
                borrar = false;
            }
        }
        return borrar;

    }

    @Override
    public void notificar() {
        for (Usuario usuario : alUsuarios) {
            usuario.recibirNotificacion("Se realizó un cambio en el Subforo: " + this.titulo);
        }
    }

}
