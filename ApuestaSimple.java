public class ApuestaSimple extends Apuesta {
    
    private LineaApuesta linea;
    
    public ApuestaSimple(double monto, Jugador jugador) {
    super(monto, jugador);
}

@Override
    public double calcularGananciaPotencial(double monto) {
        return monto * linea.getCuotaSeleccionada();
    }
}