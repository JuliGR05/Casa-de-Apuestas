import java.util.*;

public class Main {

    
public static int leerEntero(Scanner sc) {
    while (!sc.hasNextInt()) {
        System.out.println("Por favor ingrese un número válido");
        sc.next(); // limpia entrada
    }
    return sc.nextInt();
}

public static double leerDouble(Scanner sc) {
    while (true) {
        try {
            String input = sc.nextLine(); 
            input = input.replace(",", "."); // para la coma

            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido");
        }
    }
}

public static String leerTexto(Scanner sc) {
    while (true) {
        String texto = sc.nextLine();

        if (texto.matches("[a-zA-Z]+")) {
            return texto;
        } else {
            System.out.println("Por favor ingrese solo letras");
        }
    }
}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CasaDeApuestas casa = new CasaDeApuestas("BetMaster");

        int opcion;

        do {
            System.out.println("\n1. Registrar jugador");
            System.out.println("2. Registrar evento");
            System.out.println("3. Crear ticket");
            System.out.println("4. Listar tickets");
            System.out.println("0. Salir");

            opcion = leerEntero(sc);
            sc.nextLine();

            if (opcion == 1) {

                System.out.print("Nombre: ");
                String nombre = leerTexto(sc);

                System.out.print("ID: ");
                String id = sc.nextLine();

                System.out.print("Saldo: ");
                double saldo = leerDouble(sc);

                if (saldo <= 0) {
                System.out.println("Saldo inválido");
                continue;
            }

                Jugador jugador = new Jugador(nombre, id, saldo);
                casa.agregarJugador(jugador);

            } else if (opcion == 2) {

                System.out.print("Código: ");
                String codigo = sc.nextLine();

                System.out.print("Descripción: ");
                String desc = sc.nextLine();

                System.out.print("Cuota local: ");
                double cl = leerDouble(sc);

                System.out.print("Cuota empate: ");
                double ce = leerDouble(sc);

                System.out.print("Cuota visitante: ");
                double cv = leerDouble(sc);

                EventoDeportivo evento = new EventoDeportivo(codigo, desc, cl, ce, cv);
                casa.agregarEvento(evento);

            } else if (opcion == 3) {

                System.out.print("ID jugador: ");
                String id = sc.nextLine();

                Jugador jugador = casa.buscarJugador(id);

                if (jugador == null) {
                    System.out.println("Jugador no encontrado");
                    continue;
                }

                System.out.print("Monto: ");
                double monto = leerDouble(sc);

                if (monto <= 0) {
                    System.out.println("El monto debe ser mayor a 0");
                    continue;
                }


                if (!jugador.descontarSaldo(monto)) {
                    System.out.println("Saldo insuficiente");
                    continue;
                }

                System.out.print("Código evento: ");
                String codEvento = sc.nextLine();

                EventoDeportivo evento = casa.buscarEvento(codEvento);

                if (evento == null) {
                System.out.println("Evento no encontrado");
                continue;

                }
            System.out.println("Tipo de apuesta:");
            System.out.println("1. Simple");
            System.out.println("2. Múltiple");

            int tipo = leerEntero(sc);
            sc.nextLine();

            Apuesta apuesta;

            if (tipo == 1) {

                // SIMPLE
                LineaApuesta linea = new LineaApuesta(evento, TipoPronostico.LOCAL, evento.getCuotaLocal());

                apuesta = new ApuestaSimple(monto, jugador, linea);

            } else {

                // MÚLTIPLE
                List<LineaApuesta> lineas = new ArrayList<>();

                // 2 líneas
                    lineas.add(new LineaApuesta(evento, TipoPronostico.LOCAL, evento.getCuotaLocal()));
                    lineas.add(new LineaApuesta(evento, TipoPronostico.VISITANTE, evento.getCuotaVisitante()));

                    apuesta = new ApuestaMultiple(monto, jugador, lineas);
                }

            // creación línea
            LineaApuesta linea = new LineaApuesta(evento, TipoPronostico.LOCAL, evento.getCuotaLocal());

            // creación ticket
            TicketApuesta ticket = new TicketApuesta("T" + System.currentTimeMillis(), jugador, monto);

            // agregar línea
            ticket.agregarLinea(linea);

            // asociación bidireccional ticket y jugador
            jugador.agregarTicket(ticket);

            // guardar en casa
            casa.agregarTicket(ticket);

            System.out.println("Ticket creado correctamente");

             System.out.println("Ganancia potencial: " + apuesta.calcularGananciaPotencial(monto));

            } else if (opcion == 4) {

                casa.listarTickets();

            } 
            
        } while (opcion != 0);

            sc.close();

            // PRUEBA POLIMORFISMO
            System.out.println("\n--- PRUEBA POLIMORFISMO ---");

            List<Apuesta> apuestas = new ArrayList<>();

            // datos de prueba
            Jugador j = new Jugador("Test", "999", 1000);
            EventoDeportivo e = new EventoDeportivo("E99", "Test vs Test", 2.0, 3.0, 2.5);

            LineaApuesta l = new LineaApuesta(e, TipoPronostico.LOCAL, e.getCuotaLocal());

            List<LineaApuesta> lista = new ArrayList<>();
            lista.add(l);

            Apuesta a1 = new ApuestaSimple(100, j, l);
            Apuesta a2 = new ApuestaMultiple(100, j, lista);

            apuestas.add(a1);
            apuestas.add(a2);

            for (Apuesta a : apuestas) {
                System.out.println("Ganancia: " + a.calcularGananciaPotencial(a.getMonto()));
            }
        }            
}