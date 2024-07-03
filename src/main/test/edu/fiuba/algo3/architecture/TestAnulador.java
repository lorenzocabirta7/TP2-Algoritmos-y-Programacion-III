package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Anulador.Anulador;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestAnulador {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Anulador anulador;

    @BeforeEach
    public void setUp() {
    anulador = new Anulador();
    jugador1 = new Jugador("jugador1");
    jugador2 = new Jugador("jugador2");
    jugador3 = new Jugador("jugador3");

    }

    @Test
    public void test01UnAnuladorDesactivadoNoAnulaNingunPuntaje() {

        int puntajeEsperado1 = 5;
        int puntajeEsperado2 = 3;
        int puntajeEsperado3 = 2;

        int puntajeObtenido1 = anulador.anular(5,jugador1);
        int puntajeObtenido2 = anulador.anular(3,jugador2);
        int puntajeObtenido3 = anulador.anular(2,jugador3);

        assertEquals(puntajeEsperado1, puntajeObtenido1);
        assertEquals(puntajeEsperado2, puntajeObtenido2);
        assertEquals(puntajeEsperado3, puntajeObtenido3);
    }

    @Test
    public void test02UnAnuladorActivadoAnulaLosPuntajesDelQueNoLoActiva() {
        int puntajeEsperado1 = 5;
        int puntajeEsperado2 = 0;
        int puntajeEsperado3 = 0;

        anulador.activar(jugador1);
        int puntajeObtenido1 = anulador.anular(5,jugador1);
        int puntajeObtenido2 = anulador.anular(3,jugador2);
        int puntajeObtenido3 = anulador.anular(2,jugador3);

        assertEquals(puntajeEsperado1,puntajeObtenido1);
        assertEquals(puntajeEsperado2,puntajeObtenido2);
        assertEquals(puntajeEsperado3,puntajeObtenido3);

    }

    @Test
    public void test03DosJugadoresActivanUnAnuladorYSeAnulanTodosLosPuntajes(){
        int puntajeEsperado1 = 0;
        int puntajeEsperado2 = 0;
        int puntajeEsperado3 = 0;

        anulador.activar(jugador1);
        anulador.activar(jugador2);
        int puntajeObtenido1 = anulador.anular(5,jugador1);
        int puntajeObtenido2 = anulador.anular(3,jugador2);
        int puntajeObtenido3 = anulador.anular(2,jugador3);

        assertEquals(puntajeEsperado1,puntajeObtenido1);
        assertEquals(puntajeEsperado2,puntajeObtenido2);
        assertEquals(puntajeEsperado3,puntajeObtenido3);
    }

}

