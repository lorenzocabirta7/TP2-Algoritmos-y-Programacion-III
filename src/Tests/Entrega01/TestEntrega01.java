package Tests.Entrega01;

import main.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestEntrega01 {
    @org.junit.jupiter.api.Test
    public void test01UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {

        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrectaVerdaderoFalsoClasico respuesta1 = new RespuestaCorrectaVerdaderoFalsoClasico();
        RespuestaIncorrectaVerdaderoFalsoClasico respuesta2 = new RespuestaIncorrectaVerdaderoFalsoClasico();

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(respuestasPosibles);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);
    }


    @org.junit.jupiter.api.Test
    public void test02unaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){

        //Una PreguntadeVerdadero/Falso clásico recibe una lista de respuestas
        //y asigna correctamente puntos a los jugadores que respondieron de forma incorrecta❌.

            int puntajeEsperadoJugador1 = 0;
            int puntajeEsperadoJugador2 = 0;

            String enunciado = "Estamos en el año 2000?";

            RespuestaCorrectaVerdaderoFalsoClasico respuesta1 = new RespuestaCorrectaVerdaderoFalsoClasico();
            RespuestaIncorrectaVerdaderoFalsoClasico respuesta2 = new RespuestaIncorrectaVerdaderoFalsoClasico();

            ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

            respuestasPosibles.add(respuesta2);
            respuestasPosibles.add(respuesta1);

            PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

            Jugador jugador1 = new Jugador("Jugador 1");
            Jugador jugador2 = new Jugador("Jugador 2");

            jugador1.responder(pregunta);
            jugador2.responder(pregunta);

            pregunta.puntuar(respuestasPosibles);

            int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
            int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

            assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
            assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);
    }

    @org.junit.jupiter.api.Test
    public void test03unaPreguntaDeMultipleChoiceClasicoRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        //UnaPreguntadeMúltipleChoiceclásicorecibeunalistaderespuestadeunjugador
        // yasignacorrectamentepuntosalosjugadoresquerespondieroncorrectamente✅.

    }

    @org.junit.jupiter.api.Test
    public void test04unaPreguntaDeMultipleChoiceClasicoRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){



    }

    @org.junit.jupiter.api.Test
    public void test05unaPreguntaDeVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        // Una Pregunta de Verdadero/Falso con penalidad recibe una lista de respuestas
        // y asigna correctamente puntos a los jugadores que respondieron correctamente ✅.

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;

        String enunciado = "Gano la seleccion la copa america?";

        RespuestaCorrectaVerdaderoFalsoPenalidad respuesta1 = new RespuestaCorrectaVerdaderoFalsoPenalidad();
        RespuestaIncorrectaVerdaderoFalsoPenalidad respuesta2 = new RespuestaIncorrectaVerdaderoFalsoPenalidad();

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(respuestasPosibles);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test06unaPreguntaDeVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){

        int puntajeEsperadoJugador1 = -1;
        int puntajeEsperadoJugador2 = -1;

        String enunciado = "Gano la seleccion la copa america?";

        RespuestaCorrectaVerdaderoFalsoPenalidad respuesta1 = new RespuestaCorrectaVerdaderoFalsoPenalidad();
        RespuestaIncorrectaVerdaderoFalsoPenalidad respuesta2 = new RespuestaIncorrectaVerdaderoFalsoPenalidad();

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta1);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(respuestasPosibles);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test07unaPreguntaDeMultipleChoiceConPenalidadRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){



    }

    @org.junit.jupiter.api.Test
    public void test08unaPreguntaDeMultipleChoiceConPenalidadRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){



    }

}