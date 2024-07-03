package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Anulador.Anulador;
import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestExclusividad {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Exclusividad exclusividad;

    @BeforeEach
    public void setUp() {
        exclusividad = new Exclusividad();
        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador3 = new Jugador("jugador3");

    }

    @Test
    public void test01UnaExclusividadDesactivadaNoExcluyeNingunPuntaje() {

        int puntajeEsperado1 = 5;
        int puntajeEsperado2 = 3;
        int puntajeEsperado3 = 2;

        ArrayList<Jugador> jugadoresQueRespondieronCorrectamente = new ArrayList<>();
        jugadoresQueRespondieronCorrectamente.add(jugador1);
        jugadoresQueRespondieronCorrectamente.add(jugador2);
        jugadoresQueRespondieronCorrectamente.add(jugador3);

        int puntajeObtenido1 = exclusividad.excluir(5,jugador1, jugadoresQueRespondieronCorrectamente);
        int puntajeObtenido2 = exclusividad.excluir(3,jugador2, jugadoresQueRespondieronCorrectamente);
        int puntajeObtenido3 = exclusividad.excluir(2,jugador3, jugadoresQueRespondieronCorrectamente);

        assertEquals(puntajeEsperado1, puntajeObtenido1);
        assertEquals(puntajeEsperado2, puntajeObtenido2);
        assertEquals(puntajeEsperado3, puntajeObtenido3);
    }

    @Test
    public void test02UnaExclusividadActivadaExcluyeLosPuntajesCuandoSoloUnJugadorRespondeCorrectamente() {
        int puntajeEsperado1 = 10;
        int puntajeEsperado2 = 0;
        int puntajeEsperado3 = 0;

        ArrayList<Jugador> jugadoresQueRespondieronCorrectamente = new ArrayList<>();
        jugadoresQueRespondieronCorrectamente.add(jugador1);


        exclusividad.activar(jugador1);
        int puntajeObtenido1 = exclusividad.excluir(5,jugador1, jugadoresQueRespondieronCorrectamente);
        int puntajeObtenido2 = exclusividad.excluir(3,jugador2, jugadoresQueRespondieronCorrectamente);
        int puntajeObtenido3 = exclusividad.excluir(2,jugador3, jugadoresQueRespondieronCorrectamente);

        assertEquals(puntajeEsperado1,puntajeObtenido1);
        assertEquals(puntajeEsperado2,puntajeObtenido2);
        assertEquals(puntajeEsperado3,puntajeObtenido3);

    }

    @Test
    public void test03TresJugadoresActivanUnaExclusividadYSeExcluyenTodosLosPuntajesYElUnicoQueRepondeBienSeLeMultiplicaElPuntajePorSeis(){
        int puntajeEsperado1 = 6;
        int puntajeEsperado2 = 0;
        int puntajeEsperado3 = 0;

        ArrayList<Jugador> jugadoresQueRespondieronCorrectamente = new ArrayList<>();
        jugadoresQueRespondieronCorrectamente.add(jugador1);


        exclusividad.activar(jugador1);
        exclusividad.activar(jugador2);
        exclusividad.activar(jugador3);
        int puntajeObtenido1 = exclusividad.excluir(1,jugador1, jugadoresQueRespondieronCorrectamente);
        int puntajeObtenido2 = exclusividad.excluir(3,jugador2, jugadoresQueRespondieronCorrectamente);
        int puntajeObtenido3 = exclusividad.excluir(2,jugador3, jugadoresQueRespondieronCorrectamente);

        assertEquals(puntajeEsperado1,puntajeObtenido1);
        assertEquals(puntajeEsperado2,puntajeObtenido2);
        assertEquals(puntajeEsperado3,puntajeObtenido3);
    }

}