package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException;
import edu.fiuba.algo3.modelo.modificadores.MultiplicadorPorTres;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMultiplicadorPorTres {
    @Test
    public void test01TriplicadorDePuntajeNoTriplicaUnPuntajeDado() {

        int PuntajeEsperado = 2;
        MultiplicadorPorTres multiplicador = new MultiplicadorPorTres();
        int puntajeObtenido = multiplicador.modificarPuntaje(2);

        assertEquals(puntajeObtenido, PuntajeEsperado);

    }

    @Test
    public void test02TriplicadorSeActivaYDuplicaUnPuntajeDado() throws ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperado = 6;
        int unPuntaje = 2;
        MultiplicadorPorTres multiplicador = new MultiplicadorPorTres();
        multiplicador.activar();
        int puntajeObtenido = multiplicador.modificarPuntaje(unPuntaje);
        assertEquals(puntajeObtenido,puntajeEsperado);
    }

    @Test
    public void test03UnTriplicadorDePuntajeSeActivaYSeUsaDosVecesDeberiaDuplicarUnaVezElPuntaje() throws ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperado = 6;
        int unPuntaje = 2;
        MultiplicadorPorTres multiplicador = new MultiplicadorPorTres();
        multiplicador.activar();
        int puntajeObtenido = multiplicador.modificarPuntaje(unPuntaje);
        puntajeObtenido = multiplicador.modificarPuntaje(puntajeObtenido);
        assertEquals(puntajeObtenido,puntajeEsperado);
    }

    @Test
    public void test04UnTriplicadorDePuntajeSeActivaDosVecesDeberiaLanzarUnaExcepcion() throws ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperado = 4;
        int unPuntaje = 2;
        MultiplicadorPorTres multiplicador = new MultiplicadorPorTres();
        multiplicador.activar();
        int puntajeObtenido = multiplicador.modificarPuntaje(unPuntaje);
        try {
            multiplicador.activar();
        } catch (ModificadorSeUsaMasDeUnaVezException e) {
            assertEquals(e.getMessage(), "No hay usos disponibles");
        }

    }
}