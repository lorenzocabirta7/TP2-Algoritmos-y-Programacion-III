//package TestClases;
//
//import main.Jugador;
//import main.DuplicadorDePuntaje;
//import main.exceptions.ModificadorSeUsaMasDeUnaVezException;
//import org.junit.jupiter.api.Disabled;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestDuplicadorDePuntaje {
//    @org.junit.jupiter.api.Test
//    @Disabled
//    public void test01DuplicadorDePuntajeDuplicaUnPuntajeDado() {
//
//        int PuntajeEsperado = 4;
//        DuplicadorDePuntaje multiplicador = new DuplicadorDePuntaje();
//        int unPuntaje = 2;
//
//        int puntajeObtenido = multiplicador.modificarPuntaje(unPuntaje);
//
//        assertEquals(puntajeObtenido, PuntajeEsperado);
//
//    }
//    @org.junit.jupiter.api.Test
//    @Disabled
//    public void test02UnDuplicadorDePuntajeSeQuiereUsarMasDeUnaVezLanzaUnaExcepcion() {
//
//        DuplicadorDePuntaje multiplicador = new DuplicadorDePuntaje();
//        multiplicador.modificarPuntaje(1);
//        int puntajeObtenido = multiplicador.modificarPuntaje(2);
//        assertEquals(2, puntajeObtenido);
//
//    }
//}