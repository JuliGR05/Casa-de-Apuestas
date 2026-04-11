import java.util.ArrayList;
import java.util.List;

public class Jugador extends Persona {
    private String id;
    private double saldo;
    List <TicketApuesta> tickets; 

    //Constructor
    public Jugador (String nombre, String id, double saldo) {
        super (nombre);
        this.id = id;
        this.saldo = saldo;
        this.tickets = new ArrayList <> ();
    }

    public String getId(){
        return id;
    }

    public double getSaldo (){
        return saldo;
    }

    public List <TicketApuesta> getTickets (){
        return tickets;
    }
    

     public void agregarSaldo(double monto) {
        if(monto > 0){
            saldo += monto;
        }
    }

    public boolean descontarSaldo(double monto) {
        if(monto > 0 && saldo >= monto){
            saldo -= monto;
            return true;
        }
        return false; // saldo insuficiente o monto no váido
    }

    public void agregarTicket(TicketApuesta ticket) {
        tickets.add(ticket);
    }

    
    @Override
    public String getIdentificador() {
        return id;
    }
}