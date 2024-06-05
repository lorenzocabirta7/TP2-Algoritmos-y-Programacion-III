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

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        RespuestaCorrecta respuestaDelJugador1 = new RespuestaCorrecta("Si");
        RespuestaCorrecta respuestaDelJugador2 = new RespuestaCorrecta("Si");


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

            RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("No");
            RespuestaIncorrecta respuestaDeLaPregunta2 = new RespuestaIncorrecta("SI", new RespuestaClasica());

            ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();


            respuestasPosibles.add(respuestaDeLaPregunta1);
            respuestasPosibles.add(respuestaDeLaPregunta2);

            Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

            Jugador jugador1 = new Jugador("Jugador 1");
            Jugador jugador2 = new Jugador("Jugador 2");

            RespuestaIncorrecta respuestaDelJugador1 = new RespuestaIncorrecta("Si", new RespuestaClasica());
            RespuestaIncorrecta respuestaDelJugador2 = new RespuestaIncorrecta("Si", new RespuestaClasica());


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

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new RespuestaClasica());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");


        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("2");
        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("2");

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

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuesta3 = new RespuestaIncorrecta("3", new RespuestaClasica());
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("4", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        RespuestaIncorrecta respuesta1DelJugador1 = new RespuestaIncorrecta("3", new RespuestaClasica());
        RespuestaIncorrecta respuesta2DelJugador1 = new RespuestaIncorrecta("4", new RespuestaClasica());
        RespuestaIncorrecta respuesta1DelJugador2 = new RespuestaIncorrecta("3", new RespuestaClasica());
        RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("4", new RespuestaClasica());

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

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Todavia No");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("Si", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        RespuestaCorrecta respuestaDelJugador1 = new RespuestaCorrecta("Todavia No");
        RespuestaCorrecta respuestaDelJugador2 = new RespuestaCorrecta("Todavia No");

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

        RespuestaCorrecta respuestaALaPregunta1 = new RespuestaCorrecta("Todavia no");
        RespuestaIncorrecta respuestaALaPregunta2 = new RespuestaIncorrecta("Si", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaALaPregunta1);
        respuestasPosibles.add(respuestaALaPregunta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        RespuestaIncorrecta respuestaDelJugador1 = new RespuestaIncorrecta("Si", new RespuestaConPenalidad());
        RespuestaIncorrecta respuestaDelJugador2 = new RespuestaIncorrecta("Si", new RespuestaConPenalidad());


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

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuesta3 = new RespuestaIncorrecta("3", new RespuestaConPenalidad());
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("4", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new PreguntaMultipleChoicePenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("2");
        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("2");

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

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuesta3 = new RespuestaIncorrecta("3", new RespuestaConPenalidad());
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("4", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new PreguntaMultipleChoicePenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        RespuestaIncorrecta respuesta1DelJugador1 = new RespuestaIncorrecta("3", new RespuestaConPenalidad());
        RespuestaIncorrecta respuesta2DelJugador1 = new RespuestaIncorrecta("4", new RespuestaConPenalidad());
        RespuestaIncorrecta respuesta1DelJugador2 = new RespuestaIncorrecta("3", new RespuestaConPenalidad());
        RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("4", new RespuestaConPenalidad());

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