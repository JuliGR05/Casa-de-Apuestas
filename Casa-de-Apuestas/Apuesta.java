public abstract  class Apuesta implements CalculableGanancia {
    protected double monto;
    protected Jugador jugador;

    public Apuesta(double monto, Jugador jugador) {
        this.monto = monto;
        this.jugador = jugador;
    }

    public double getMonto() {
        return monto;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public abstract double calcularGananciaPotencial(double monto);

    }
