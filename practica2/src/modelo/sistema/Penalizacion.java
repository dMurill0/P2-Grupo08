package modelo.sistema;


public class Penalizacion{
    
    private boolean tienePenalizacion = false;
    private int diasPenalizacion;
    
    public Penalizacion(int dias) {
	diasPenalizacion = dias;
        tienePenalizacion = true;
    }
	
    public boolean estaPenalizado() {
	return tienePenalizacion;
    }
	
    public void avanzarDias(int dias) {
	diasPenalizacion -= dias;
	if(diasPenalizacion < 0) {
            diasPenalizacion = 0;
            tienePenalizacion = false;
        }
    }
    
}
