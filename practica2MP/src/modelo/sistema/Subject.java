package modelo.sistema;

import modelo.usuario.Usuario;

public interface Subject {
    public boolean anadirSubscriptor(Usuario subs);
    public boolean eliminarSubscriptor(Usuario subs);
    public void notificar();
}
