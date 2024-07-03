package edu.fiuba.algo3.entrega_1;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ModoDePregunta.GroupChoice;
import edu.fiuba.algo3.modelo.ModoDePregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.ModoDePregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.ModoDePregunta.VerdaderoOFalso;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadParcialMC;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaAVerificar;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntrega01 {
   @Test
   public void test01UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {

       //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
       //correctamente puntos a los jugadores que respondieron correctamente

       int puntajeEsperadoJugador1 = 1;
       int puntajeEsperadoJugador2 = 1;

       String enunciado = "Estamos en el año 2024?";
       String enunciadoRespuestaCorrecta = "SI";
       String enunciadoRespuestaIncorrecta = "NO";

       Respuesta respuesta1 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, "0");
       Respuesta respuesta2 = new RespuestaIncorrecta(enunciadoRespuestaIncorrecta);

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new VerdaderoOFalso( new PenalidadClasica())) ;

       Jugador jugador1 = new Jugador("Jugador 1");
       Jugador jugador2 = new Jugador("Jugador 2");

       jugador1.agregarRespuesta(pregunta, respuesta1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuesta1);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();

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

       RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("NO", "0");
       RespuestaIncorrecta respuestaDeLaPregunta2 = new RespuestaIncorrecta("SI");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

       respuestasPosibles.add(respuestaDeLaPregunta1);
       respuestasPosibles.add(respuestaDeLaPregunta2);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new VerdaderoOFalso( new PenalidadClasica() ));

       Jugador jugador1 = new Jugador("Jugador 1");
       Jugador jugador2 = new Jugador("Jugador 2");

       RespuestaIncorrecta respuestaDelJugador1 = new RespuestaIncorrecta("SI");
       RespuestaIncorrecta respuestaDelJugador2 = new RespuestaIncorrecta("SI");

       jugador1.agregarRespuesta(pregunta, respuestaDelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuestaDelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();

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

       RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1", "0");
       RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2", "0");
       RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3");
       RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

       respuestasPosibles.add(respuestaDeLaPregunta1);
       respuestasPosibles.add(respuestaDeLaPregunta2);
       respuestasPosibles.add(respuestaDeLaPregunta3);
       respuestasPosibles.add(respuestaDeLaPregunta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new MultipleChoice( new PenalidadClasica()));

       Jugador jugador1 = new Jugador("Riquelme");
       Jugador jugador2 = new Jugador("Palermo");


       RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("1", "0");
       RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("2", "0");
       RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("1", "0");
       RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("2", "0");

       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       RespuestaCorrecta respuesta1 = new RespuestaCorrecta("1", "0");
       RespuestaCorrecta respuesta2 = new RespuestaCorrecta("2", "0");
       RespuestaIncorrecta respuesta3 = new RespuestaIncorrecta("3");
       RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("4");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);
       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new MultipleChoice( new PenalidadClasica()));

       Jugador jugador1 = new Jugador("Riquelme");
       Jugador jugador2 = new Jugador("Palermo");

       RespuestaIncorrecta respuesta1DelJugador1 = new RespuestaIncorrecta("3");
       RespuestaIncorrecta respuesta2DelJugador1 = new RespuestaIncorrecta("4");
       RespuestaIncorrecta respuesta1DelJugador2 = new RespuestaIncorrecta("3");
       RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("4");

       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
       int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
       int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

       assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
       assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

   }

   @org.junit.jupiter.api.Test
   public void test05unaPreguntaDeVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        //Una Pregunta de Verdadero/Falso con penalidad recibe una lista de respuestas
        //y asigna correctamente puntos a los jugadores que respondieron correctamente ✅.

       int puntajeEsperadoJugador1 = 1;
       int puntajeEsperadoJugador2 = 1;

       String enunciado = "Gano la seleccion la copa america?";

       RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Todavia No", "0");
       RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("Si");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new VerdaderoOFalso( new PenalidadConPenalidad()));

       Jugador jugador1 = new Jugador("Jugador 1");
       Jugador jugador2 = new Jugador("Jugador 2");

       RespuestaCorrecta respuestaDelJugador1 = new RespuestaCorrecta("Todavia No","0");
       RespuestaCorrecta respuestaDelJugador2 = new RespuestaCorrecta("Todavia No", "0");

       jugador1.agregarRespuesta(pregunta, respuestaDelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuestaDelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();

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

       RespuestaCorrecta respuestaALaPregunta1 = new RespuestaCorrecta("Todavia No", "0");
       RespuestaIncorrecta respuestaALaPregunta2 = new RespuestaIncorrecta("Si");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuestaALaPregunta1);
       respuestasPosibles.add(respuestaALaPregunta2);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new VerdaderoOFalso( new PenalidadConPenalidad()));

       Jugador jugador1 = new Jugador("Jugador 1");
       Jugador jugador2 = new Jugador("Jugador 2");

       RespuestaIncorrecta respuestaDelJugador1 = new RespuestaIncorrecta("Si");
       RespuestaIncorrecta respuestaDelJugador2 = new RespuestaIncorrecta("Si");

       jugador1.agregarRespuesta(pregunta, respuestaDelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuestaDelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       RespuestaCorrecta respuesta1 = new RespuestaCorrecta("1", "0");
       RespuestaCorrecta respuesta2 = new RespuestaCorrecta("2", "0");
       RespuestaIncorrecta respuesta3 = new RespuestaIncorrecta("3");
       RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("4");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new MultipleChoice( new PenalidadConPenalidad()));

       Jugador jugador1 = new Jugador("Riquelme");
       Jugador jugador2 = new Jugador("Palermo");

       RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("1", "0");
       RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("2", "0");
       RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("1", "0");
       RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("2", "0");

       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       RespuestaCorrecta respuesta1 = new RespuestaCorrecta("1", "0");
       RespuestaCorrecta respuesta2 = new RespuestaCorrecta("2", "0");
       RespuestaIncorrecta respuesta3 = new RespuestaIncorrecta("3");
       RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("4");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new MultipleChoice( new PenalidadConPenalidad()));

       Jugador jugador1 = new Jugador("Riquelme");
       Jugador jugador2 = new Jugador("Palermo");

       RespuestaIncorrecta respuesta1DelJugador1 = new RespuestaIncorrecta("3");
       RespuestaIncorrecta respuesta2DelJugador1 = new RespuestaIncorrecta("4");
       RespuestaIncorrecta respuesta1DelJugador2 = new RespuestaIncorrecta("3");
       RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("4");

       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani", "0");
       RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez","0");
       RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli","0");
       RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new MultipleChoice( new PenalidadParcialMC()));

       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");

       RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("Franco Armani","0");
       RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("Emiliano Martinez","0");
       RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("Geronimo Rulli", "0");
       RespuestaCorrecta respuesta2DelJugador2 = new RespuestaCorrecta("Franco Armani","0");

       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani","0");
       RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez","0");
       RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli","0");
       RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new MultipleChoice( new PenalidadParcialMC()));

       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");

       RespuestaIncorrecta respuesta1DelJugador1 = new RespuestaIncorrecta("Franco Armani");
       RespuestaIncorrecta respuesta2DelJugador1 = new RespuestaIncorrecta("Emiliano Martinez");
       RespuestaIncorrecta respuesta1DelJugador2 = new RespuestaIncorrecta("Geronimo Rulli");
       RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("Franco Armani");

       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani","0");
       RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez","0");
       RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli","0");
       RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new MultipleChoice( new PenalidadParcialMC()));

       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");

       RespuestaCorrecta respuesta1DelJugador1 = new RespuestaCorrecta("Franco Armani","0");
       RespuestaCorrecta respuesta2DelJugador1 = new RespuestaCorrecta("Emiliano Martinez","0");
       RespuestaCorrecta respuesta3DelJugador1 = new RespuestaCorrecta("Geronimo Rulli","0");
       RespuestaCorrecta respuesta1DelJugador2 = new RespuestaCorrecta("Geronimo Rulli","0");
       RespuestaIncorrecta respuesta2DelJugador2 = new RespuestaIncorrecta("Sergio Romero");

       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta3DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       Respuesta respuesta1 = new RespuestaCorrecta("A", "1");
       Respuesta respuesta2 = new RespuestaCorrecta("E","2");
       Respuesta respuesta3 = new RespuestaCorrecta("F", "3");
       Respuesta respuesta4 = new RespuestaCorrecta("Z", "4");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new OrderedChoice( new PenalidadClasica()));

       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");

       Respuesta respuesta1DelJugador1 = new RespuestaAVerificar("A","1");
       Respuesta respuesta2DelJugador1 = new RespuestaAVerificar("E","2");
       Respuesta respuesta3DelJugador1 = new RespuestaAVerificar("F","3");
       Respuesta respuesta4DelJugador1 = new RespuestaAVerificar("Z","4");


       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta3DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta4DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       Respuesta respuesta1DelJugador2 = new RespuestaAVerificar("A","1");
       Respuesta respuesta2DelJugador2 = new RespuestaAVerificar("E","2");
       Respuesta respuesta3DelJugador2 = new RespuestaAVerificar("F","3");
       Respuesta respuesta4DelJugador2 = new RespuestaAVerificar("Z","4");

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta3DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta4DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
       int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
       int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

       assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
       assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

   }

   @org.junit.jupiter.api.Test
   public void test13unaPreguntaDeOrderedChoiceRecibeUnaListaDeRespuestaDeUnJugadorYAsignaCorrectamentePuntosALosJugadoresQueRespondieronDeFormaIncorrecta(){
       //Una Pregunta de OrderedChoice recibe una lista de respuestas de un jugador
       //y asigna correctamente puntos a los jugadores que respondieron de incorrecta ❌.

       int puntajeEsperadoJugador1 = 0;
       int puntajeEsperadoJugador2 = 0;

       String enunciado = "Colocar estas letras en orden alfabetico, [E, A ,Z, F]";

       RespuestaCorrecta respuesta1 = new RespuestaCorrecta("A","1");
       RespuestaCorrecta respuesta2 = new RespuestaCorrecta("E","2");
       RespuestaCorrecta respuesta3 = new RespuestaCorrecta("F","3");
       RespuestaCorrecta respuesta4 = new RespuestaCorrecta("Z","4");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new OrderedChoice( new PenalidadClasica()));

       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");

       Respuesta respuesta1DelJugador1 = new RespuestaAVerificar("A","1");
       Respuesta respuesta3DelJugador1 = new RespuestaAVerificar("F","2");
       Respuesta respuesta2DelJugador1 = new RespuestaAVerificar("E","3");
       Respuesta respuesta4DelJugador1 = new RespuestaAVerificar("Z","4");


       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta3DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta4DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       Respuesta respuesta1DelJugador2 = new RespuestaAVerificar("A","4");
       Respuesta respuesta3DelJugador2 = new RespuestaAVerificar("F", "2");
       Respuesta respuesta2DelJugador2 = new RespuestaAVerificar("E","3");
       Respuesta respuesta4DelJugador2 = new RespuestaAVerificar("Z","1");

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta3DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta4DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       Respuesta respuesta1 = new RespuestaCorrecta("A","1");
       Respuesta respuesta2 = new RespuestaCorrecta("E","2");
       Respuesta respuesta3 = new RespuestaCorrecta("F","3");
       Respuesta respuesta4 = new RespuestaCorrecta("Z", "4");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new OrderedChoice( new PenalidadClasica()));

       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");

       Respuesta respuesta1DelJugador1 = new RespuestaAVerificar("A","1");
       Respuesta respuesta2DelJugador1 = new RespuestaAVerificar("E","2");
       Respuesta respuesta3DelJugador1 = new RespuestaAVerificar("F","3");
       Respuesta respuesta4DelJugador1 = new RespuestaAVerificar("Z","4");


       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta3DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta4DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       Respuesta respuesta1DelJugador2 = new RespuestaAVerificar("A","1");
       Respuesta respuesta2DelJugador2 = new RespuestaAVerificar("E","3");
       Respuesta respuesta3DelJugador2 = new RespuestaAVerificar("F","2");
       Respuesta respuesta4DelJugador2 = new RespuestaAVerificar("Z","4");

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta3DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta4DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       Respuesta respuesta1 = new RespuestaCorrecta("A","Letras");
       Respuesta respuesta2 = new RespuestaCorrecta("M","Letras");
       Respuesta respuesta3 = new RespuestaCorrecta("0","Numeros");
       Respuesta respuesta4 = new RespuestaCorrecta("2","Numeros");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new GroupChoice( new PenalidadClasica()));

       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");

       Respuesta respuesta1DelJugador1 = new RespuestaAVerificar("A","Letras");
       Respuesta respuesta2DelJugador1 = new RespuestaAVerificar("M","Letras");
       Respuesta respuesta3DelJugador1 = new RespuestaAVerificar("0","Numeros");
       Respuesta respuesta4DelJugador1 = new RespuestaAVerificar("2","Numeros");


       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta3DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta4DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       Respuesta respuesta1DelJugador2 = new RespuestaAVerificar("A","Letras");
       Respuesta respuesta2DelJugador2 = new RespuestaAVerificar("M","Letras");
       Respuesta respuesta3DelJugador2 = new RespuestaAVerificar("0","Numeros");
       Respuesta respuesta4DelJugador2 = new RespuestaAVerificar("2","Numeros");

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta3DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta4DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       Respuesta respuesta1 = new RespuestaCorrecta("A","Letras");
       Respuesta respuesta2 = new RespuestaCorrecta("M","Letras");
       Respuesta respuesta3 = new RespuestaCorrecta("0","Numeros");
       Respuesta respuesta4 = new RespuestaCorrecta("2","Numeros");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new GroupChoice( new PenalidadClasica()));

       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");

       Respuesta respuesta1DelJugador1 = new RespuestaAVerificar("A","Letras");
       Respuesta respuesta2DelJugador1 = new RespuestaAVerificar("M","Letras");
       Respuesta respuesta3DelJugador1 = new RespuestaAVerificar("0","Letras");
       Respuesta respuesta4DelJugador1 = new RespuestaAVerificar("2","Numeros");


       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta3DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta4DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       Respuesta respuesta1DelJugador2 = new RespuestaAVerificar("A","Letras");
       Respuesta respuesta2DelJugador2 = new RespuestaAVerificar("M","Numeros");
       Respuesta respuesta3DelJugador2 = new RespuestaAVerificar("0","Letras");
       Respuesta respuesta4DelJugador2 = new RespuestaAVerificar("2","Letras");

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta3DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta4DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
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

       Respuesta respuesta1 = new RespuestaCorrecta("A","Letras");
       Respuesta respuesta2 = new RespuestaCorrecta("M","Letras");
       Respuesta respuesta3 = new RespuestaCorrecta("0","Numeros");
       Respuesta respuesta4 = new RespuestaCorrecta("2","Numeros");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new GroupChoice( new PenalidadClasica()));

       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");

       Respuesta respuesta1DelJugador1 = new RespuestaAVerificar("A","Numeros");
       Respuesta respuesta2DelJugador1 = new RespuestaAVerificar("M","Numeros");
       Respuesta respuesta3DelJugador1 = new RespuestaAVerificar("0","Numeros");
       Respuesta respuesta4DelJugador1 = new RespuestaAVerificar("2","Numeros");

       jugador1.agregarRespuesta(pregunta, respuesta1DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta2DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta3DelJugador1);
       jugador1.agregarRespuesta(pregunta, respuesta4DelJugador1);
       jugador1.confirmarRespuesta(pregunta);

       Respuesta respuesta1DelJugador2 = new RespuestaAVerificar("A","Letras");
       Respuesta respuesta2DelJugador2 = new RespuestaAVerificar("M","Letras");
       Respuesta respuesta3DelJugador2 = new RespuestaAVerificar("0","Numeros");
       Respuesta respuesta4DelJugador2 = new RespuestaAVerificar("2","Numeros");

       jugador2.agregarRespuesta(pregunta, respuesta1DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta2DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta3DelJugador2);
       jugador2.agregarRespuesta(pregunta, respuesta4DelJugador2);
       jugador2.confirmarRespuesta(pregunta);

       pregunta.puntuarJugadores();
       int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
       int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

       assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
       assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);

   }

   @org.junit.jupiter.api.Test
   public void Test18DosJugadoresJueganUnaPartidaDe3Preguntas(){

       int puntajeEsperadoJugador1 = 2;
       int puntajeEsperadoJugador2 = 2;

       //Preparamos un arreglo con las preguntas que se van a jugar
       String enunciado = "Separar en grupos las letras y los numeros [M, A, 0, 2]";

       Respuesta respuesta1 = new RespuestaCorrecta("A","Letras");
       Respuesta respuesta2 = new RespuestaCorrecta("M","Letras");
       Respuesta respuesta3 = new RespuestaCorrecta("0","Numeros");
       Respuesta respuesta4 = new RespuestaCorrecta("2","Numeros");

       ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

       respuestasPosibles.add(respuesta1);
       respuestasPosibles.add(respuesta2);
       respuestasPosibles.add(respuesta3);
       respuestasPosibles.add(respuesta4);

       Pregunta pregunta1 = new Pregunta(enunciado, "Sin Tema", respuestasPosibles, new OrderedChoice( new PenalidadClasica()));

       String enunciado2 = "Colocar estas letras en orden alfabetico, [E, A ,Z, F]";

       Respuesta respuesta1Pregunta2 = new RespuestaCorrecta("A", "1");
       Respuesta respuesta2Pregunta2 = new RespuestaCorrecta("E","2");
       Respuesta respuesta3Pregunta2 = new RespuestaCorrecta("F", "3");
       Respuesta respuesta4Pregunta2 = new RespuestaCorrecta("Z", "4");

       ArrayList<Respuesta> respuestasPosibles2 = new ArrayList<Respuesta>();

       respuestasPosibles2.add(respuesta1Pregunta2);
       respuestasPosibles2.add(respuesta2Pregunta2);
       respuestasPosibles2.add(respuesta3Pregunta2);
       respuestasPosibles2.add(respuesta4Pregunta2);

       Pregunta pregunta2 = new Pregunta(enunciado2, "Sin Tema", respuestasPosibles2, new OrderedChoice( new PenalidadClasica()));

       String enunciado3 = "Estamos en el año 2024?";
       String enunciadoRespuestaCorrecta = "SI";
       String enunciadoRespuestaIncorrecta = "NO";

       RespuestaCorrecta respuesta1Pregunta3 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, "0");
       RespuestaIncorrecta respuesta2Pregunta3 = new RespuestaIncorrecta(enunciadoRespuestaIncorrecta);



       ArrayList<Respuesta> respuestasPosibles3 = new ArrayList<>();


       respuestasPosibles3.add(respuesta1Pregunta3);
       respuestasPosibles3.add(respuesta2Pregunta3);

       Pregunta pregunta3 = new Pregunta(enunciado3, "Sin Tema", respuestasPosibles3, new VerdaderoOFalso( new PenalidadClasica() ));


       ArrayList<Pregunta> preguntasDelJuego = new ArrayList<>();

       preguntasDelJuego.add(pregunta1);
       preguntasDelJuego.add(pregunta2);
       preguntasDelJuego.add(pregunta3);



       //empieza el juego ahora



       Jugador jugador1 = new Jugador("Manuel");
       Jugador jugador2 = new Jugador("Sebastian");


       Pregunta preguntaAResponder = preguntasDelJuego.get(0);

       Respuesta respuesta1DelJugador1 = new RespuestaAVerificar("A","Numeros");
       Respuesta respuesta2DelJugador1 = new RespuestaAVerificar("M","Numeros");
       Respuesta respuesta3DelJugador1 = new RespuestaAVerificar("0","Numeros");
       Respuesta respuesta4DelJugador1 = new RespuestaAVerificar("2","Numeros");

       jugador1.agregarRespuesta(preguntaAResponder, respuesta1DelJugador1);
       jugador1.agregarRespuesta(preguntaAResponder, respuesta2DelJugador1);
       jugador1.agregarRespuesta(preguntaAResponder, respuesta3DelJugador1);
       jugador1.agregarRespuesta(preguntaAResponder, respuesta4DelJugador1);
       jugador1.confirmarRespuesta(preguntaAResponder);


       Respuesta respuesta1DelJugador2 = new RespuestaAVerificar("A","Letras");
       Respuesta respuesta2DelJugador2 = new RespuestaAVerificar("M","Letras");
       Respuesta respuesta3DelJugador2 = new RespuestaAVerificar("0","Numeros");
       Respuesta respuesta4DelJugador2 = new RespuestaAVerificar("2","Numeros");

       jugador2.agregarRespuesta(preguntaAResponder, respuesta1DelJugador2);
       jugador2.agregarRespuesta(preguntaAResponder, respuesta2DelJugador2);
       jugador2.agregarRespuesta(preguntaAResponder, respuesta3DelJugador2);
       jugador2.agregarRespuesta(preguntaAResponder, respuesta4DelJugador2);
       jugador2.confirmarRespuesta(preguntaAResponder);

       preguntaAResponder.puntuarJugadores();
       jugador1.resetRespuestas();
       jugador2.resetRespuestas();

       //se mostrarian aca los puntajes
       //int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
       //int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

       preguntaAResponder = preguntasDelJuego.get(1);

       jugador1.resetRespuestas();
       jugador2.resetRespuestas();

       respuesta1DelJugador1 = new RespuestaAVerificar("A","1");
       respuesta2DelJugador1 = new RespuestaAVerificar("E","2");
       respuesta3DelJugador1 = new RespuestaAVerificar("F","3");
       respuesta4DelJugador1 = new RespuestaAVerificar("Z","4");

       jugador1.agregarRespuesta(preguntaAResponder, respuesta1DelJugador1);
       jugador1.agregarRespuesta(preguntaAResponder, respuesta2DelJugador1);
       jugador1.agregarRespuesta(preguntaAResponder, respuesta3DelJugador1);
       jugador1.agregarRespuesta(preguntaAResponder, respuesta4DelJugador1);
       jugador1.confirmarRespuesta(preguntaAResponder);

       respuesta1DelJugador2 = new RespuestaAVerificar("A","1");
       respuesta2DelJugador2 = new RespuestaAVerificar("E","3");
       respuesta3DelJugador2 = new RespuestaAVerificar("F","2");
       respuesta4DelJugador2 = new RespuestaAVerificar("Z","4");

       jugador2.agregarRespuesta(preguntaAResponder, respuesta1DelJugador2);
       jugador2.agregarRespuesta(preguntaAResponder, respuesta2DelJugador2);
       jugador2.agregarRespuesta(preguntaAResponder, respuesta3DelJugador2);
       jugador2.agregarRespuesta(preguntaAResponder, respuesta4DelJugador2);
       jugador2.confirmarRespuesta(preguntaAResponder);

       preguntaAResponder.puntuarJugadores();
       jugador1.resetRespuestas();
       jugador2.resetRespuestas();
       //se mostrarian aca los puntajes
       //int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
       //int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

       preguntaAResponder = preguntasDelJuego.get(2);

       jugador1.resetRespuestas();
       jugador2.resetRespuestas();

       Respuesta respuestaDelJugador1 = new RespuestaCorrecta("SI", "0");
       Respuesta respuestaDelJugador2 = new RespuestaCorrecta("SI", "0");

       jugador1.agregarRespuesta(preguntaAResponder, respuestaDelJugador1);
       jugador1.confirmarRespuesta(preguntaAResponder);

       jugador2.agregarRespuesta(preguntaAResponder, respuestaDelJugador2);
       jugador2.confirmarRespuesta(preguntaAResponder);

       preguntaAResponder.puntuarJugadores();
       jugador1.resetRespuestas();
       jugador2.resetRespuestas();
       int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
       int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

       assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
       assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);
   }
}