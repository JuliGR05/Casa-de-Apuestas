import java.util.List;
import java.util.ArrayList;

public class CasaDeApuestas {
    private String nombre;
    private List <Jugador> jugadores;
    private List <EventoDeportivo> eventos;
    private List <TicketApuesta> tickets;
    
    //Constructor 
    public CasaDeApuestas(String nombre) {
    this.nombre = nombre;
    this.jugadores = new ArrayList<>();
    this.eventos = new ArrayList<>();
    this.tickets = new ArrayList<>();
}

    public void agregarJugador( Jugador jugador ) {
    for (Jugador j : jugadores) {
        if (j.getId().equals(jugador.getId())) {
            System.out.println("El jugador ya fue creado");
        return;
    }
}
        jugadores.add(jugador);
}

    public void agregarEvento (EventoDeportivo evento){
    for (EventoDeportivo e : eventos) {
        if (e.getCodigo().equals(evento.getCodigo())) {
            System.out.println("El evento ya fue creado");
        return;
    }
}
    eventos.add(evento);

}

    public Jugador buscarJugador(String id) {
    for (Jugador j: jugadores) {
        if (j.getId().equals(id)) {
        return j;
        }
    }
    return null;
}

    public EventoDeportivo buscarEvento(String codigo) {
    for (EventoDeportivo e: eventos) {
        if (e.getCodigo().equals(codigo)) {
        return e;
        }
    }
    return null;
}
                        
}
