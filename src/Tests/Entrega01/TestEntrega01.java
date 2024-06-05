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

        RespuestaCorrectaVerdaderoFalsoClasico respuestaDelJugador1 = new RespuestaCorrectaVerdaderoFalsoClasico("Si");
        RespuestaCorrectaVerdaderoFalsoClasico respuestaDelJugador2 = new RespuestaCorrectaVerdaderoFalsoClasico("Si");


        jugador1.responder(pregunta, respuestaDelJugador1);
        jugador2.responder(pregunta, respuestaDelJugador2);

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

            RespuestaCorrectaVerdaderoFalsoClasico respuestaDeLaPregunta1 = new RespuestaCorrectaVerdaderoFalsoClasico("No");
            RespuestaIncorrectaVerdaderoFalsoClasico respuestaDeLaPregunta2 = new RespuestaIncorrectaVerdaderoFalsoClasico("Si");

            ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();


            respuestasPosibles.add(respuestaDeLaPregunta1);
            respuestasPosibles.add(respuestaDeLaPregunta2);

            Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

            Jugador jugador1 = new Jugador("Jugador 1");
            Jugador jugador2 = new Jugador("Jugador 2");

            RespuestaIncorrectaVerdaderoFalsoClasico respuestaDelJugador1 = new RespuestaIncorrectaVerdaderoFalsoClasico("Si");
            RespuestaIncorrectaVerdaderoFalsoClasico respuestaDelJugador2 = new RespuestaIncorrectaVerdaderoFalsoClasico("Si");


            jugador1.responder(pregunta, respuestaDelJugador1);
            jugador2.responder(pregunta, respuestaDelJugador2);

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

        RespuestaCorrectaMultipleChoiceClasico respuestaDeLaPregunta1 = new RespuestaCorrectaMultipleChoiceClasico("1");
        RespuestaCorrectaMultipleChoiceClasico respuestaDeLaPregunta2 = new RespuestaCorrectaMultipleChoiceClasico("2");
        RespuestaIncorrectaMultipleChoiceClasico respuestaDeLaPregunta3 = new RespuestaIncorrectaMultipleChoiceClasico("3");
        RespuestaIncorrectaMultipleChoiceClasico respuestaDeLaPregunta4 = new RespuestaIncorrectaMultipleChoiceClasico("4");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");


        RespuestaCorrectaMultipleChoiceClasico respuesta1DelJugador1 = new RespuestaCorrectaMultipleChoiceClasico("1");
        RespuestaCorrectaMultipleChoiceClasico respuesta2DelJugador1 = new RespuestaCorrectaMultipleChoiceClasico("2");
        RespuestaCorrectaMultipleChoiceClasico respuesta1DelJugador2 = new RespuestaCorrectaMultipleChoiceClasico("1");
        RespuestaCorrectaMultipleChoiceClasico respuesta2DelJugador2 = new RespuestaCorrectaMultipleChoiceClasico("2");

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);

        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

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

        RespuestaIncorrectaMultipleChoiceClasico respuesta1DelJugador1 = new RespuestaIncorrectaMultipleChoiceClasico("3");
        RespuestaIncorrectaMultipleChoiceClasico respuesta2DelJugador1 = new RespuestaIncorrectaMultipleChoiceClasico("4");
        RespuestaIncorrectaMultipleChoiceClasico respuesta1DelJugador2 = new RespuestaIncorrectaMultipleChoiceClasico("3");
        RespuestaIncorrectaMultipleChoiceClasico respuesta2DelJugador2 = new RespuestaIncorrectaMultipleChoiceClasico("4");

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

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

        RespuestaCorrectaVerdaderoFalsoPenalidad respuestaDelJugador1 = new RespuestaCorrectaVerdaderoFalsoPenalidad("Todavia No");
        RespuestaCorrectaVerdaderoFalsoPenalidad respuestaDelJugador2 = new RespuestaCorrectaVerdaderoFalsoPenalidad("Todavia No");

        jugador1.responder(pregunta, respuestaDelJugador1);
        jugador2.responder(pregunta, respuestaDelJugador2);

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

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        RespuestaIncorrectaVerdaderoFalsoPenalidad respuestaDelJugador1 = new RespuestaIncorrectaVerdaderoFalsoPenalidad("Si");
        RespuestaIncorrectaVerdaderoFalsoPenalidad respuestaDelJugador2 = new RespuestaIncorrectaVerdaderoFalsoPenalidad("Si");


        jugador1.responder(pregunta, respuestaDelJugador1);
        jugador2.responder(pregunta, respuestaDelJugador2);

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

        RespuestaCorrectaMultipleChoicePenalidad respuesta1DelJugador1 = new RespuestaCorrectaMultipleChoicePenalidad("1");
        RespuestaCorrectaMultipleChoicePenalidad respuesta2DelJugador1 = new RespuestaCorrectaMultipleChoicePenalidad("2");
        RespuestaCorrectaMultipleChoicePenalidad respuesta1DelJugador2 = new RespuestaCorrectaMultipleChoicePenalidad("1");
        RespuestaCorrectaMultipleChoicePenalidad respuesta2DelJugador2 = new RespuestaCorrectaMultipleChoicePenalidad("2");

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

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

        String enunciado = "Cuantas patas puede tener una gallina?";

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

        RespuestaIncorrectaMultipleChoicePenalidad respuesta1DelJugador1 = new RespuestaIncorrectaMultipleChoicePenalidad("3");
        RespuestaIncorrectaMultipleChoicePenalidad respuesta2DelJugador1 = new RespuestaIncorrectaMultipleChoicePenalidad("4");
        RespuestaIncorrectaMultipleChoicePenalidad respuesta1DelJugador2 = new RespuestaIncorrectaMultipleChoicePenalidad("3");
        RespuestaIncorrectaMultipleChoicePenalidad respuesta2DelJugador2 = new RespuestaIncorrectaMultipleChoicePenalidad("4");

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);


    }

}