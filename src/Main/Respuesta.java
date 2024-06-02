package main;

import java.util.ArrayList;

public class Respuesta {
    private final String contenido;
    private final boolean veracidad;
    private ArrayList<Jugador> jugadoresQueEligieron;

    public Respuesta(String unContenido, boolean unaVeracidad) {
        this.contenido = unContenido;
        this.veracidad = unaVeracidad;
        this.jugadoresQueEligieron = new ArrayList<Jugador>();
    }

    public boolean esCorrecta(){
        return this.veracidad;
    }

    public void fueElegidaPor(Jugador jugador) {
        this.jugadoresQueEligieron.add(jugador);
    }


    public void actualizar_puntaje(int puntaje) {
        for (int i = 0; i < jugadoresQueEligieron.size(); i++) {
            jugadoresQueEligieron.get(i).aumentar_puntaje(puntaje);
        }

    }
}
