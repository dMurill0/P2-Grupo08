package modelo.sistema;

import java.util.Calendar;


public class Penalizacion{
    
    private Calendar fechaInicio;
    private Calendar fechaFinalizacion;

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Calendar fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}
