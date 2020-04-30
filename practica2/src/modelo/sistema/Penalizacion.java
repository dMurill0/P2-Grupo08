package modelo.sistema;


public class Penalizacion{
    
    private boolean tienePenalizacion = false;
    private int diasPenalizacion;
    
    
    public Penalizacion(){
        this.tienePenalizacion = false;
    }
    public Penalizacion(int dias) {
	diasPenalizacion = dias;
        tienePenalizacion = true;
    }
	
    public boolean estaPenalizado() {
	return tienePenalizacion;
    }

    public boolean isTienePenalizacion() {
        return tienePenalizacion;
    }

    public void setTienePenalizacion(boolean tienePenalizacion) {
        this.tienePenalizacion = tienePenalizacion;
    }

    public int getDiasPenalizacion() {
        return diasPenalizacion;
    }

    public void setDiasPenalizacion(int diasPenalizacion) {
        this.diasPenalizacion = diasPenalizacion;
    }
    
    
    
}
