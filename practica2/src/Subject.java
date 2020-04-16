/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alberto
 */
public interface Subject {
    public void anadirSubscriptor(Usuario subs);
    public void eliminarSubscriptor(Usuario subs);
    public void notificar();
}
