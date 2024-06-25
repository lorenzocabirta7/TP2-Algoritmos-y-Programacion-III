package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException;
import edu.fiuba.algo3.modelo.modificadores.MultiplicadorPorDos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMultiplicadorPorDos {
    @Test
    public void test01DuplicadorDePuntajeNoDuplicaUnPuntajeDado() {

        int PuntajeEsperado = 2;
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();
        int puntajeObtenido = multiplicador.modificarPuntaje(2);

        assertEquals(puntajeObtenido, PuntajeEsperado);

    }
    @Test
    public void test02DuplicadorSeActivaYDuplicaUnPuntajeDado() throws ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperado = 4;
        int unPuntaje = 2;
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();
        multiplicador.activar();
        int puntajeObtenido = multiplicador.modificarPuntaje(unPuntaje);
        assertEquals(puntajeObtenido,puntajeEsperado);
    }

    @Test
    public void test03UnDuplicadorDePuntajeSeActivaYSeUsaDosVecesDeberiaDuplicarUnaVezElPuntaje() throws ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperado = 4;
        int unPuntaje = 2;
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();
        multiplicador.activar();
        int puntajeObtenido = multiplicador.modificarPuntaje(unPuntaje);
        puntajeObtenido = multiplicador.modificarPuntaje(puntajeObtenido);
        assertEquals(puntajeObtenido,puntajeEsperado);
    }

    @Test
    public void test04UnDuplicadorDePuntajeSeActivaDosVecesDeberiaLanzarUnaExcepcion() throws ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperado = 4;
        int unPuntaje = 2;
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();
        multiplicador.activar();
        int puntajeObtenido = multiplicador.modificarPuntaje(unPuntaje);
        try {
            multiplicador.activar();
        } catch (ModificadorSeUsaMasDeUnaVezException e) {
            assertEquals(e.getMessage(), "No hay usos disponibles");
        }

    }
}