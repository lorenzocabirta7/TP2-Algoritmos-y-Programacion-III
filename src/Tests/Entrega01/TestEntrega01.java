package Tests.Entrega01;

import main.*;
import main.Respuestas.*;
import main.preguntas.*;

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
        String enunciadoRespuestaCorrecta = "SI";
        String enunciadoRespuestaIncorrecta = "NO";


        RespuestaCorrecta respuesta1 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, new SinOrden());
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta(enunciadoRespuestaCorrecta, new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarVerdaderoFalsoClasico());

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        RespuestaCorrecta respuestaDelJugador1 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, new SinOrden());
        RespuestaCorrecta respuestaDelJugador2 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, new SinOrden());

        jugador1.responder(pregunta, respuestaDelJugador1);
        jugador2.responder(pregunta, respuestaDelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
    }


    @org.junit.jupiter.api.Test
    public void test02unaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta() {

        //Una PreguntadeVerdadero/Falso clásico recibe una lista de respuestas
        //y asigna correctamente puntos a los jugadores que respondieron de forma incorrecta❌.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Estamos en el año 2000?";

        String enunciadoRespuestaCorrecta = "NO";
        String enunciadoRespuestaIncorrecta = "SI";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, new SinOrden());
        RespuestaIncorrecta respuestaDeLaPregunta2 = new RespuestaIncorrecta(enunciadoRespuestaIncorrecta, new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();


        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarVerdaderoFalsoClasico());

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        RespuestaIncorrecta respuestaDelJugador1 = new RespuestaIncorrecta(enunciadoRespuestaIncorrecta, new PenalidadClasica());
        RespuestaIncorrecta respuestaDelJugador2 = new RespuestaIncorrecta(enunciadoRespuestaIncorrecta, new PenalidadClasica());

        jugador1.responder(pregunta, respuestaDelJugador1);
        jugador2.responder(pregunta, respuestaDelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
    }

    @org.junit.jupiter.api.Test
    public void test03unaPreguntaDeMultipleChoiceClasicoRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        //Una Pregunta de MúltipleChoiceclásico recibe una lista de respuestas de un jugador
        // y asigna correctamente puntos a los jugadores que respondieron correctamente✅.

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1", new SinOrden());
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2", new SinOrden());
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new PenalidadClasica());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceClasico(respuestasPosibles));

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");


        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("1", new SinOrden());
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("2", new SinOrden());
        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("1", new SinOrden());
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("2", new SinOrden());

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);

        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

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

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("1", new SinOrden());
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("2", new SinOrden());
        RespuestaIncorrecta respuesta3 = new RespuestaIncorrecta("3", new PenalidadClasica());
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("4", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceClasico(respuestasPosibles));

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        RespuestaIncorrecta respuesta1DelJugador1 = new RespuestaIncorrecta("3", new PenalidadClasica());
        RespuestaIncorrecta respuesta2DelJugador1 = new RespuestaIncorrecta("4", new PenalidadClasica());
        RespuestaIncorrecta respuesta1DelJugador2 = new RespuestaIncorrecta("3", new PenalidadClasica());
        RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("4", new PenalidadClasica());

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

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

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Todavia No", new SinOrden());
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("Si", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarVerdaderoFalsoPenalidad());

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        RespuestaCorrecta respuestaDelJugador1 = new RespuestaCorrecta("Todavia No", new SinOrden());
        RespuestaCorrecta respuestaDelJugador2 = new RespuestaCorrecta("Todavia No", new SinOrden());

        jugador1.responder(pregunta, respuestaDelJugador1);
        jugador2.responder(pregunta, respuestaDelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

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

        RespuestaCorrecta respuestaALaPregunta1 = new RespuestaCorrecta("Todavia No", new SinOrden());
        RespuestaIncorrecta respuestaALaPregunta2 = new RespuestaIncorrecta("Si", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaALaPregunta1);
        respuestasPosibles.add(respuestaALaPregunta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarVerdaderoFalsoPenalidad());

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        RespuestaIncorrecta respuestaDelJugador1 = new RespuestaIncorrecta("Si", new PenalidadConPenalidad());
        RespuestaIncorrecta respuestaDelJugador2 = new RespuestaIncorrecta("Si", new PenalidadConPenalidad());


        jugador1.responder(pregunta, respuestaDelJugador1);
        jugador2.responder(pregunta, respuestaDelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

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

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("1", new SinOrden());
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("2", new SinOrden());
        RespuestaIncorrecta respuesta3 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("4", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoicePenalidad());

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("1", new SinOrden());
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("2", new SinOrden());
        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("1", new SinOrden());
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("2", new SinOrden());

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

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

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("1", new SinOrden());
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("2", new SinOrden());
        RespuestaIncorrecta respuesta3 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("4", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoicePenalidad());

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");

        RespuestaIncorrecta respuesta1DelJugador1 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());
        RespuestaIncorrecta respuesta2DelJugador1 = new RespuestaIncorrecta("4", new PenalidadConPenalidad());
        RespuestaIncorrecta respuesta1DelJugador2 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());
        RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("4", new PenalidadConPenalidad());

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);


    }

    @org.junit.jupiter.api.Test
    public void test09unaPreguntaDeMultipleChoiceParcialRecibeUnaListaDeRespuestaDeJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaCorrecta(){
        //Una Pregunta de MúltipleChoiceParcial recibe una lista de respuestas de 2 jugadores
        //y asigna correctamente puntos a los jugadores que respondieron de forma Correcta ✅.

        int puntajeEsperadoJugador1 = 2;
        int puntajeEsperadoJugador2 = 2;

        String enunciado = "Cuales fueron los 3 arqueros de Argentina en el mundial 2022?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani", new SinOrden());
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez",new SinOrden());
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli",new SinOrden());
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceParcial(respuestasPosibles));

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("Franco Armani",new SinOrden());
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("Emiliano Martinez",new SinOrden());
        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("Geronimo Rulli",new SinOrden());
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("Franco Armani",new SinOrden());

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test10unaPreguntaDeMultipleChoiceParcialRecibeUnaListaDeRespuestaDe1JugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){
        //Una Pregunta de MúltipleChoiceParcial recibe una lista de respuestas de 2 jugadores
        //y asigna correctamente puntos a los jugadores que respondieron de forma Incorrecta ❌.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Cuales fueron los 3 arqueros de Argentina en el mundial 2022?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani",new SinOrden());
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez",new SinOrden());
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli",new SinOrden());
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceParcial(respuestasPosibles));

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");

        RespuestaIncorrecta respuesta1DelJugador1 = new RespuestaIncorrecta("Franco Armani", new PenalidadClasica());
        RespuestaIncorrecta respuesta2DelJugador1 = new RespuestaIncorrecta("Emiliano Martinez", new PenalidadClasica());
        RespuestaIncorrecta respuesta1DelJugador2 = new RespuestaIncorrecta("Geronimo Rulli", new PenalidadClasica());
        RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("Franco Armani", new PenalidadClasica());

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }


    @org.junit.jupiter.api.Test
    public void test11unaPreguntaDeMultipleChoiceParcialRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaCorrecta(){
        //Una Pregunta de MúltipleChoiceParcial recibe una lista de respuestas de un jugador
        //y asigna correctamente puntos a los jugadores que respondieron de forma Correcta e incorrectamente ✅❌.

        int puntajeEsperadoJugador1 = 3;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Cuales fueron los 3 arqueros de Argentina en el mundial 2022?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani",new SinOrden());
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez",new SinOrden());
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli",new SinOrden());
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceParcial(respuestasPosibles));

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("Franco Armani",new SinOrden());
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("Emiliano Martinez",new SinOrden());
        RespuestaCorrecta respuesta3DelJugador1 = new RespuestaCorrecta("Geronimo Rulli",new SinOrden());
        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("Geronimo Rulli",new SinOrden());
        RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("Sergio Romero", new PenalidadConPenalidad());

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador1.responder(pregunta, respuesta3DelJugador1);
        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test12unaPreguntaDeOrderedChoiceRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaCorrecta(){
        //Una Pregunta de OrderedChoice recibe una lista de respuestas de un jugador
        //y asigna correctamente puntos a los jugadores que respondieron de forma Correcta ✅.

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;

        String enunciado = "Colocar estas letras en orden alfabetico, [E, A ,Z, F]";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "1"));
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("E",new ConOrdenParcial("E", "2"));
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("F",new ConOrdenParcial("F", "3"));
        RespuestaCorrecta respuesta4 = new RespuestaCorrecta("Z", new ConOrdenParcial("Z", "4"));

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarDeFormaOrdenada(respuestasPosibles));

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "1"));
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("E",new ConOrdenParcial("E", "2"));
        RespuestaCorrecta respuesta3DelJugador1 = new RespuestaCorrecta("F",new ConOrdenParcial("F", "3"));
        RespuestaCorrecta respuesta4DelJugador1 = new RespuestaCorrecta("Z",new ConOrdenParcial("Z", "4"));


        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador1.responder(pregunta, respuesta3DelJugador1);
        jugador1.responder(pregunta, respuesta4DelJugador1);

        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "1"));
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("E",new ConOrdenParcial("E", "2"));
        RespuestaCorrecta respuesta3DelJugador2 = new RespuestaCorrecta("F",new ConOrdenParcial("F", "3"));
        RespuestaCorrecta respuesta4DelJugador2 = new RespuestaCorrecta("Z",new ConOrdenParcial("Z", "4"));

        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);
        jugador2.responder(pregunta, respuesta3DelJugador2);
        jugador2.responder(pregunta, respuesta4DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test13unaPreguntaDeOrderedChoiceRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){
        //Una Pregunta de MúltipleChoiceParcial recibe una lista de respuestas de un jugador
        //y asigna correctamente puntos a los jugadores que respondieron de incorrecta ❌.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Colocar estas letras en orden alfabetico, [E, A ,Z, F]";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "1"));
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("E",new ConOrdenParcial("E", "2"));
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("F",new ConOrdenParcial("F", "3"));
        RespuestaCorrecta respuesta4 = new RespuestaCorrecta("Z", new ConOrdenParcial("Z", "4"));

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarDeFormaOrdenada(respuestasPosibles));

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "1"));
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("E",new ConOrdenParcial("F", "2"));
        RespuestaCorrecta respuesta3DelJugador1 = new RespuestaCorrecta("F",new ConOrdenParcial("E", "3"));
        RespuestaCorrecta respuesta4DelJugador1 = new RespuestaCorrecta("Z",new ConOrdenParcial("Z", "4"));


        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador1.responder(pregunta, respuesta3DelJugador1);
        jugador1.responder(pregunta, respuesta4DelJugador1);

        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "1"));
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("E",new ConOrdenParcial("F", "2"));
        RespuestaCorrecta respuesta3DelJugador2 = new RespuestaCorrecta("F",new ConOrdenParcial("E", "3"));
        RespuestaCorrecta respuesta4DelJugador2 = new RespuestaCorrecta("Z",new ConOrdenParcial("Z", "4"));

        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);
        jugador2.responder(pregunta, respuesta3DelJugador2);
        jugador2.responder(pregunta, respuesta4DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test14unaPreguntaDeOrderedChoiceRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieron(){
        //Una Pregunta de MúltipleChoiceParcial recibe una lista de respuestas de un jugador
        //y asigna correctamente puntos a los jugadores que respondieron de forma Correcta e incorrectamente ✅❌.

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Colocar estas letras en orden alfabetico, [E, A ,Z, F]";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "1"));
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("E",new ConOrdenParcial("E", "2"));
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("F",new ConOrdenParcial("F", "3"));
        RespuestaCorrecta respuesta4 = new RespuestaCorrecta("Z", new ConOrdenParcial("Z", "4"));

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarDeFormaOrdenada(respuestasPosibles));

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "1"));
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("E",new ConOrdenParcial("E", "2"));
        RespuestaCorrecta respuesta3DelJugador1 = new RespuestaCorrecta("F",new ConOrdenParcial("F", "3"));
        RespuestaCorrecta respuesta4DelJugador1 = new RespuestaCorrecta("Z",new ConOrdenParcial("Z", "4"));


        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador1.responder(pregunta, respuesta3DelJugador1);
        jugador1.responder(pregunta, respuesta4DelJugador1);

        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "1"));
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("E",new ConOrdenParcial("F", "2"));
        RespuestaCorrecta respuesta3DelJugador2 = new RespuestaCorrecta("F",new ConOrdenParcial("E", "3"));
        RespuestaCorrecta respuesta4DelJugador2 = new RespuestaCorrecta("Z",new ConOrdenParcial("Z", "4"));

        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);
        jugador2.responder(pregunta, respuesta3DelJugador2);
        jugador2.responder(pregunta, respuesta4DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test15unaPreguntaDeGroupChoiceRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaCorrecta(){
        //Una Pregunta de GroupChoice recibe una lista de respuestas de un jugador
        //y asigna correctamente puntos a los jugadores que respondieron de forma Correcta ✅.

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;

        String enunciado = "Separar en grupos las letras y los numeros [M, A, 0, 2]";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "Letras"));
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("M",new ConOrdenParcial("M", "Letras"));
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("0",new ConOrdenParcial("0", "Numeros"));
        RespuestaCorrecta respuesta4 = new RespuestaCorrecta("2", new ConOrdenParcial("2", "Numeros"));

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarDeFormaOrdenada(respuestasPosibles));

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "Letras"));
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("M",new ConOrdenParcial("M", "Letras"));
        RespuestaCorrecta respuesta3DelJugador1 = new RespuestaCorrecta("0",new ConOrdenParcial("0", "Numeros"));
        RespuestaCorrecta respuesta4DelJugador1 = new RespuestaCorrecta("2",new ConOrdenParcial("2", "Numeros"));


        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador1.responder(pregunta, respuesta3DelJugador1);
        jugador1.responder(pregunta, respuesta4DelJugador1);

        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "Letras"));
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("M",new ConOrdenParcial("M", "Letras"));
        RespuestaCorrecta respuesta3DelJugador2 = new RespuestaCorrecta("0",new ConOrdenParcial("0", "Numeros"));
        RespuestaCorrecta respuesta4DelJugador2 = new RespuestaCorrecta("2",new ConOrdenParcial("2", "Numeros"));

        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);
        jugador2.responder(pregunta, respuesta3DelJugador2);
        jugador2.responder(pregunta, respuesta4DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test16unaPreguntaDeGroupChoiceRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){
        //Una Pregunta de GroupChoice recibe una lista de respuestas de un jugador
        //y asigna correctamente puntos a los jugadores que respondieron de forma Incorrecta ❌.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Separar en grupos las letras y los numeros [M, A, 0, 2]";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "Letras"));
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("M",new ConOrdenParcial("M", "Letras"));
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("0",new ConOrdenParcial("0", "Numeros"));
        RespuestaCorrecta respuesta4 = new RespuestaCorrecta("2", new ConOrdenParcial("2", "Numeros"));

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarDeFormaOrdenada(respuestasPosibles));

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("A",new ConOrdenParcial("0", "Letras"));
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("M",new ConOrdenParcial("M", "Letras"));
        RespuestaCorrecta respuesta3DelJugador1 = new RespuestaCorrecta("0",new ConOrdenParcial("A", "Numeros"));
        RespuestaCorrecta respuesta4DelJugador1 = new RespuestaCorrecta("2",new ConOrdenParcial("2", "Numeros"));


        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador1.responder(pregunta, respuesta3DelJugador1);
        jugador1.responder(pregunta, respuesta4DelJugador1);

        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "Letras"));
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("M",new ConOrdenParcial("M", "Letras"));
        RespuestaCorrecta respuesta3DelJugador2 = new RespuestaCorrecta("0",new ConOrdenParcial("0", "Letras"));
        RespuestaCorrecta respuesta4DelJugador2 = new RespuestaCorrecta("2",new ConOrdenParcial("2", "Letras"));

        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);
        jugador2.responder(pregunta, respuesta3DelJugador2);
        jugador2.responder(pregunta, respuesta4DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

    @org.junit.jupiter.api.Test
    public void test17unaPreguntaDeGroupChoiceRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieron(){
        //Una Pregunta de GroupChoice recibe una lista de respuestas de un jugador
        //y asigna correctamente puntos a los jugadores que respondieron de forma Incorrecta ✅❌.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 1;

        String enunciado = "Separar en grupos las letras y los numeros [M, A, 0, 2]";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "Letras"));
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("M",new ConOrdenParcial("M", "Letras"));
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("0",new ConOrdenParcial("0", "Numeros"));
        RespuestaCorrecta respuesta4 = new RespuestaCorrecta("2", new ConOrdenParcial("2", "Numeros"));

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarDeFormaOrdenada(respuestasPosibles));

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");

        RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("A",new ConOrdenParcial("0", "Letras"));
        RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("M",new ConOrdenParcial("M", "Letras"));
        RespuestaCorrecta respuesta3DelJugador1 = new RespuestaCorrecta("0",new ConOrdenParcial("A", "Numeros"));
        RespuestaCorrecta respuesta4DelJugador1 = new RespuestaCorrecta("2",new ConOrdenParcial("2", "Numeros"));

        jugador1.responder(pregunta, respuesta1DelJugador1);
        jugador1.responder(pregunta, respuesta2DelJugador1);
        jugador1.responder(pregunta, respuesta3DelJugador1);
        jugador1.responder(pregunta, respuesta4DelJugador1);

        RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("A",new ConOrdenParcial("A", "Letras"));
        RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("M",new ConOrdenParcial("M", "Letras"));
        RespuestaCorrecta respuesta3DelJugador2 = new RespuestaCorrecta("0",new ConOrdenParcial("0", "Numeros"));
        RespuestaCorrecta respuesta4DelJugador2 = new RespuestaCorrecta("2",new ConOrdenParcial("2", "Numeros"));

        jugador2.responder(pregunta, respuesta1DelJugador2);
        jugador2.responder(pregunta, respuesta2DelJugador2);
        jugador2.responder(pregunta, respuesta3DelJugador2);
        jugador2.responder(pregunta, respuesta4DelJugador2);

        jugador1.confirmarRespuesta(pregunta);
        jugador2.confirmarRespuesta(pregunta);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

    }

}