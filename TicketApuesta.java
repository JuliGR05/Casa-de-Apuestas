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
}