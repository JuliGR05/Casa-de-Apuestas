   import java.util.ArrayList;
    import java.util.List;

   public class TicketApuesta { 
    private String codigo;
    private Jugador jugador;
    private List <LineaApuesta> lineas;
    private double montoTotal; 


    //Constructor
    public TicketApuesta (String codigo, Jugador jugador, double montoTotal ) {
        this.codigo = codigo;
        this.jugador = jugador;
        this.montoTotal = montoTotal;
        this.lineas = new ArrayList <> ();
}

    public void agregarLinea (LineaApuesta linea) {
        lineas.add (linea);
    }

    //Getters
    public Jugador getJugador () {
        return jugador;
    }
    
    public String getCodigo() {
    return codigo;
}

    public double getMontoTotal() {
    return montoTotal;
}

    public List<LineaApuesta> getLineas() {
    return lineas;
}

public void mostrarTicket() {
    System.out.println("Código: " + codigo);
    System.out.println("Jugador: " + jugador.getNombre());
    System.out.println("Monto: " + montoTotal);
    System.out.println("Número de líneas: " + lineas.size());
}
}