package TestClases;

import main.Jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsJugador {
    @org.junit.jupiter.api.Test
    public void test01JugadorSeLeModificaElPuntaje() {

        Jugador jugador1 = new Jugador("Pirulo");

        jugador1.modificarPuntaje(5);

        int puntosJugador = jugador1.obtenerPuntos();

        assertEquals(5, puntosJugador);

    }

    @org.junit.jupiter.api.Test
    public void test02JugadorSeLeModificaElPuntajeDespuesDeUsarUnBonificador() {

        Jugador jugador1 = new Jugador("Pirulo");

        //jugador1.activar


    }
}