package TestClases;


import main.MultiplicadorPorDos;
import main.exceptions.ModificadorSeUsaMasDeUnaVezException;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMultiplicadorPorDos {
    @org.junit.jupiter.api.Test
    public void test01DuplicadorDePuntajeNoDuplicaUnPuntajeDado() {

        int PuntajeEsperado = 2;
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();
        int puntajeObtenido = multiplicador.modificarPuntaje(2);

        assertEquals(puntajeObtenido, PuntajeEsperado);

    }
    @org.junit.jupiter.api.Test
    public void test02DuplicadorSeActivaYDuplicaUnPuntajeDado() throws ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperado = 4;
        int unPuntaje = 2;
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();
        multiplicador.activar();
        int puntajeObtenido = multiplicador.modificarPuntaje(unPuntaje);
        assertEquals(puntajeObtenido,puntajeEsperado);
    }

    @org.junit.jupiter.api.Test
    public void test03UnDuplicadorDePuntajeSeActivaYSeUsaDosVecesDeberiaDuplicarUnaVezElPuntaje() throws ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperado = 4;
        int unPuntaje = 2;
        MultiplicadorPorDos multiplicador = new MultiplicadorPorDos();
        multiplicador.activar();
        int puntajeObtenido = multiplicador.modificarPuntaje(unPuntaje);
        puntajeObtenido = multiplicador.modificarPuntaje(puntajeObtenido);
        assertEquals(puntajeObtenido,puntajeEsperado);
    }

    @org.junit.jupiter.api.Test
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