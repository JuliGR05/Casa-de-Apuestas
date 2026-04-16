public class ApuestaSimple extends Apuesta {
    
    private LineaApuesta linea;
    
    public ApuestaSimple(double monto, Jugador jugador, LineaApuesta linea) {
    super(monto, jugador);
    this.linea = linea; 
}

@Override
    public double calcularGananciaPotencial(double monto) {
        return monto * linea.getCuotaSeleccionada();
    }
}