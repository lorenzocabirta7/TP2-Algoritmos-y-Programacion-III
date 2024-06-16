package edu.fiuba.algo3.architecture;



import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsJugador {
    @Test
    public void test01JugadorSeLeModificaElPuntaje() {

        Jugador jugador1 = new Jugador("Spirulina");

        jugador1.modificarPuntaje(5);

        int puntosJugador = jugador1.obtenerPuntos();

        assertEquals(5, puntosJugador);

    }

    @Test
    public void test02JugadorSeLeModificaElPuntajePorDosDespuesDeUsarUnBonificador() throws ModificadorSeUsaMasDeUnaVezException {

        int puntajeEsperado = 2;
        Jugador jugador1 = new Jugador("Spirulina");

        jugador1.activarDuplicadorDePuntaje();
        jugador1.modificarPuntaje(1);

        int puntosJugador = jugador1.obtenerPuntos();

        assertEquals(puntajeEsperado, puntosJugador);

    }

    @Test
    public void test03JugadorSeLeModificaElPuntajePorTresDespuesDeUsarUnBonificador() throws ModificadorSeUsaMasDeUnaVezException {

        int puntajeEsperado = 3;
        Jugador jugador1 = new Jugador("Spirulina");

        jugador1.activarTriplicadorDePuntaje();
        jugador1.modificarPuntaje(1);

        int puntosJugador = jugador1.obtenerPuntos();

        assertEquals(puntajeEsperado, puntosJugador);

    }

    @Test
    public void test04JugadorSeLeModificaElPuntajePorSeisDespuesDeUsarUnBonificador() throws ModificadorSeUsaMasDeUnaVezException {

        int puntajeEsperado = 6;
        Jugador jugador1 = new Jugador("Spirulina");

        jugador1.activarDuplicadorDePuntaje();
        jugador1.activarTriplicadorDePuntaje();
        jugador1.modificarPuntaje(1);

        int puntosJugador = jugador1.obtenerPuntos();

        assertEquals(puntajeEsperado, puntosJugador);

    }
}