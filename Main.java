public class Main {
    public static void main(String[] args) {

        CasaDeApuestas casa = new CasaDeApuestas("BetMaster");

        Jugador j1 = new Jugador("Juan", "1", 1000);
        casa.agregarJugador(j1);

        EventoDeportivo e1 = new EventoDeportivo("E1", "Real Madrid vs Barça", 1.5, 3.2, 2.8);
        casa.agregarEvento(e1);

        Jugador encontrado = casa.buscarJugador("1");

        if (encontrado != null) {
            System.out.println("Jugador encontrado: " + encontrado.getNombre());
        } else {
            System.out.println("Jugador no encontrado");
        }
    }
}