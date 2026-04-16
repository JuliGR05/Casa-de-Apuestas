public class LineaApuesta {
    private EventoDeportivo evento;
    private TipoPronostico pronostico;
    private double cuotaSeleccionada;


//Constructor

    public LineaApuesta(EventoDeportivo evento, TipoPronostico pronostico, double cuotaSeleccionada ) {
        this.evento = evento;
        this.pronostico = pronostico;
        this.cuotaSeleccionada = cuotaSeleccionada;

    }

// Getters
    public double getCuotaSeleccionada() {
        return cuotaSeleccionada;
    }

    public EventoDeportivo getEvento() {
        return evento;
    }

    public TipoPronostico getPronostico() {
        return pronostico;
    } 
}


