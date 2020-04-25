package modelo.usuario;

import java.util.Calendar;
import modelo.sistema.Penalizacion;


public class Alumno extends Usuario{
    
    private Penalizacion penalizacion;
    private boolean tienePenalizacion;
    
    public Alumno(String nombre, String apellidos, String nick, String contraseña, String email) {
        super(nombre, apellidos, nick, contraseña, email);
        super.setRol("alumno");
    }

    //establecer fecha de la penalizacion y sumarle dos dia(fin del ban) luego comparar esa fecha en estaPenalizado
    public boolean penalizar(){
        
        penalizacion.setFechaInicio(Calendar.getInstance());
        
        Calendar fechaFin = Calendar.getInstance();
        fechaFin.add(Calendar.DATE, 2);
        penalizacion.setFechaFinalizacion(fechaFin);

        return (this.tienePenalizacion = true);
    }

    public boolean estaPenalizado(){ //comparar las fechas de inicio y fin de la clase Penalizacion con la actual     
        if(penalizacion.getFechaInicio().compareTo(penalizacion.getFechaFinalizacion()) < 0){
            return (this.tienePenalizacion = false);
        
        }else{
            return (this.tienePenalizacion = true);
        }
    }   
}
