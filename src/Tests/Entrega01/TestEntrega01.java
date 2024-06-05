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

        RespuestaCorrectaVerdaderoFalsoClasico respuesta1 = new RespuestaCorrectaVerdaderoFalsoClasico("Si");
        RespuestaIncorrectaVerdaderoFalsoClasico respuesta2 = new RespuestaIncorrectaVerdaderoFalsoClasico("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

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

            RespuestaCorrectaVerdaderoFalsoClasico respuesta1 = new RespuestaCorrectaVerdaderoFalsoClasico("No");
            RespuestaIncorrectaVerdaderoFalsoClasico respuesta2 = new RespuestaIncorrectaVerdaderoFalsoClasico("Si");

            ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

            respuestasPosibles.add(respuesta2);
            respuestasPosibles.add(respuesta1);

            Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

            Jugador jugador1 = new Jugador("Jugador 1");
            Jugador jugador2 = new Jugador("Jugador 2");

            jugador1.responder(pregunta);
            jugador2.responder(pregunta);

            pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
            pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

            int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
            int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

            assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
            assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);
    }

    @org.junit.jupiter.api.Test
    public void test03unaPreguntaDeMultipleChoiceClasicoRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        //Una Pregunta de MúltipleChoiceclásico recibe una lista de respuestas de un jugador
        // y asigna correctamente puntos a los jugadores que respondieron correctamente✅.

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrectaMultipleChoiceClasico respuesta1 = new RespuestaCorrectaMultipleChoiceClasico("1");
        RespuestaCorrectaMultipleChoiceClasico respuesta2 = new RespuestaCorrectaMultipleChoiceClasico("2");
        RespuestaIncorrectaMultipleChoiceClasico respuesta3 = new RespuestaIncorrectaMultipleChoiceClasico("3");
        RespuestaIncorrectaMultipleChoiceClasico respuesta4 = new RespuestaIncorrectaMultipleChoiceClasico("4");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        jugador1.cambiarFormaDeResponder();
        jugador2.cambiarFormaDeResponder();

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);
    }

    @org.junit.jupiter.api.Test
    public void test04unaPreguntaDeMultipleChoiceClasicoRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){
        //Una Pregunta de MúltipleChoiceclásico recibe una lista de respuestas de un jugador
        //y asigna correctamente puntos a los jugadores que respondieron de forma incorrecta❌.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrectaMultipleChoiceClasico respuesta1 = new RespuestaCorrectaMultipleChoiceClasico("1");
        RespuestaCorrectaMultipleChoiceClasico respuesta2 = new RespuestaCorrectaMultipleChoiceClasico("2");
        RespuestaIncorrectaMultipleChoiceClasico respuesta3 = new RespuestaIncorrectaMultipleChoiceClasico("3");
        RespuestaIncorrectaMultipleChoiceClasico respuesta4 = new RespuestaIncorrectaMultipleChoiceClasico("4");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        jugador1.cambiarFormaDeResponder();
        jugador2.cambiarFormaDeResponder();

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test05unaPreguntaDeVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        // Una Pregunta de Verdadero/Falso con penalidad recibe una lista de respuestas
        // y asigna correctamente puntos a los jugadores que respondieron correctamente ✅.

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;

        String enunciado = "Gano la seleccion la copa america?";

        RespuestaCorrectaVerdaderoFalsoPenalidad respuesta1 = new RespuestaCorrectaVerdaderoFalsoPenalidad("Todavia No");
        RespuestaIncorrectaVerdaderoFalsoPenalidad respuesta2 = new RespuestaIncorrectaVerdaderoFalsoPenalidad("Si");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

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

        RespuestaCorrectaVerdaderoFalsoPenalidad respuesta1 = new RespuestaCorrectaVerdaderoFalsoPenalidad("Todavia no");
        RespuestaIncorrectaVerdaderoFalsoPenalidad respuesta2 = new RespuestaIncorrectaVerdaderoFalsoPenalidad("Si");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta1);

        Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test07unaPreguntaDeMultipleChoiceConPenalidadRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
        //Una Pregunta de MúltipleChoicePenalidad recibe una lista de respuestas de un jugador
        // y asigna correctamente puntos a los jugadores que respondieron correctamente✅.

        int puntajeEsperadoJugador1 = 2;
        int puntajeEsperadoJugador2 = 2;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrectaMultipleChoicePenalidad respuesta1 = new RespuestaCorrectaMultipleChoicePenalidad("1");
        RespuestaCorrectaMultipleChoicePenalidad respuesta2 = new RespuestaCorrectaMultipleChoicePenalidad("2");
        RespuestaIncorrectaMultipleChoicePenalidad respuesta3 = new RespuestaIncorrectaMultipleChoicePenalidad("3");
        RespuestaIncorrectaMultipleChoicePenalidad respuesta4 = new RespuestaIncorrectaMultipleChoicePenalidad("4");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new PreguntaMultipleChoicePenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        jugador1.cambiarFormaDeResponder();
        jugador2.cambiarFormaDeResponder();

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);


    }

    @org.junit.jupiter.api.Test
    public void test08unaPreguntaDeMultipleChoiceConPenalidadRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){
        //Una Pregunta de MúltipleChoicePenalidad recibe una lista de respuestas de un jugador
        //y asigna correctamente puntos a los jugadores que respondieron de forma incorrecta❌.

        int puntajeEsperadoJugador1 = -2;
        int puntajeEsperadoJugador2 = -2;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrectaMultipleChoicePenalidad respuesta1 = new RespuestaCorrectaMultipleChoicePenalidad("1");
        RespuestaCorrectaMultipleChoicePenalidad respuesta2 = new RespuestaCorrectaMultipleChoicePenalidad("2");
        RespuestaIncorrectaMultipleChoicePenalidad respuesta3 = new RespuestaIncorrectaMultipleChoicePenalidad("3");
        RespuestaIncorrectaMultipleChoicePenalidad respuesta4 = new RespuestaIncorrectaMultipleChoicePenalidad("4");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoicePenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        jugador1.cambiarFormaDeResponder();
        jugador2.cambiarFormaDeResponder();

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);


    }

}