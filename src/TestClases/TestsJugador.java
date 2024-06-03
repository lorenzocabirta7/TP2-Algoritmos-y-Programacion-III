package TestClases;

import main.Jugador;
import main.exceptions.ModificadorSeUsaMasDeUnaVezException;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsJugador {
    @org.junit.jupiter.api.Test
    public void test01JugadorSeLeModificaElPuntaje() {

        Jugador jugador1 = new Jugador("Spirulina");

        jugador1.modificarPuntaje(5);

        int puntosJugador = jugador1.obtenerPuntos();

        assertEquals(5, puntosJugador);

    }

    @org.junit.jupiter.api.Test

    public void test02JugadorSeLeModificaElPuntajeDespuesDeUsarUnBonificador() throws ModificadorSeUsaMasDeUnaVezException {

        int puntajeEsperado = 2;
        Jugador jugador1 = new Jugador("Spirulina");

        jugador1.activarDuplicadorDePuntaje();
        jugador1.modificarPuntaje(1);

        int puntosJugador = jugador1.obtenerPuntos();

        assertEquals(puntajeEsperado, puntosJugador);

    }
}