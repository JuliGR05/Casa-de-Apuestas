import java.util.List;

public class ApuestaMultiple extends Apuesta {

    private List<LineaApuesta> lineas;

    // Constructor
    public ApuestaMultiple(double monto, Jugador jugador, List<LineaApuesta> lineas) {
        super(monto, jugador);
        this.lineas = lineas;
    }

    // Método para calcular ganancia
    @Override
    public double calcularGananciaPotencial(double monto) {
        double producto = 1;

        for (LineaApuesta linea : lineas) {
            producto *= linea.getCuotaSeleccionada();
        }

        return Math.round (monto * producto);
    }
}