package edu.fiuba.algo3.modelo.DTO;

import edu.fiuba.algo3.modelo.Anulador.AnuladorClasico;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;

public class ProcesarDTO {

   public ArrayList<Pregunta> procesarPreguntas(PreguntaDTO[] listaPreguntas) {

       ArrayList<Pregunta> preguntas = new ArrayList<>();

       for (PreguntaDTO pregunta : listaPreguntas) {
           FormaDePuntuarDTO GeneradorFormaDePuntaje = new FormaDePuntuarDTO();

           if (pregunta.getTipo().equals("Group Choice")) { //los groupchoice se tienen que procesar de otra forma que el resto de las preguntas
               ArrayList<Respuesta> respuestasPregunta = procesarPreguntasGroupChoice(pregunta);

               FormaDePuntuar unaFormaDePuntuar = GeneradorFormaDePuntaje.TipoDePuntuacion(pregunta, respuestasPregunta);

               Pregunta preguntaNueva = new Pregunta(pregunta.getPregunta(), respuestasPregunta, unaFormaDePuntuar , new AnuladorClasico());
               preguntas.add(preguntaNueva);
           } else {
               ArrayList<Respuesta> respuestasPregunta = procesarPreguntasNormales(pregunta);

               FormaDePuntuar unaFormaDePuntuar = GeneradorFormaDePuntaje.TipoDePuntuacion(pregunta, respuestasPregunta);

               Pregunta preguntaNueva = new Pregunta(pregunta.getPregunta(), respuestasPregunta, unaFormaDePuntuar, new AnuladorClasico());
               preguntas.add(preguntaNueva);
           }
       }
       return preguntas;
   }



    private ArrayList<Respuesta> procesarPreguntasNormales(PreguntaDTO pregunta) {
        String[] respuestasArray = pregunta.getRespuesta().split(",");

        ArrayList<Respuesta> respuestasTotales = new ArrayList<>();


        ArrayList<String> indicesDeRespuestasCorrectas = new ArrayList<>();
        for (String indice : respuestasArray) {
            indicesDeRespuestasCorrectas.add(indice.trim());
        }


        int opcionesTotales = 6; //asumimos que pueden haber hasta 6 respuestas posibles


        for (int i = 1; i <= opcionesTotales; i++) {
            String indice = String.valueOf(i);
            String opcion = ObtenerOpcionPorOrdenParcial(pregunta, indice);
            if (opcion != null) {
                if (indicesDeRespuestasCorrectas.contains(indice)) { //si la respuesta es de tipo correcta.
                    Respuesta respuestaCorrecta = new RespuestaCorrecta(opcion, indice);
                    respuestasTotales.add(respuestaCorrecta);
                } else {
                    TipoDePenalidadDTO tipoDePenalidad = new TipoDePenalidadDTO();
                    Respuesta respuestaIncorrecta = new RespuestaIncorrecta(opcion, tipoDePenalidad.DevolverPenalidad(pregunta));
                    respuestasTotales.add(respuestaIncorrecta);
                }
            }
        }
        return respuestasTotales;
    }


   private ArrayList<Respuesta> procesarPreguntasGroupChoice(PreguntaDTO pregunta) {

       ArrayList<Respuesta> respuestas = new ArrayList<>();

       String[] grupos = pregunta.getRespuesta().split(";");

       for (String grupo : grupos) {

           String[] partes = grupo.trim().split(":");
           String nombreGrupo = partes[0].trim();
           String respuestasDelGrupo = partes[1].trim();

           String grupoEspecifico = nombreGrupo.equals("A") ? pregunta.getGrupoA() : pregunta.getGrupoB();

           String[] indices = respuestasDelGrupo.split(",");

           for (String indice : indices) {
               String unaRespuesta = ObtenerOpcionPorOrdenParcial(pregunta, indice);

               Respuesta respuesta = new RespuestaCorrecta(unaRespuesta, grupoEspecifico);
               respuestas.add(respuesta);
           }
       }
       return respuestas;
   }


    private static String ObtenerOpcionPorOrdenParcial(PreguntaDTO pregunta, String ordenParcial) {
        switch (ordenParcial) {
            case "1":
                return pregunta.getOpcion1();
            case "2":
                return pregunta.getOpcion2();
            case "3":
                return pregunta.getOpcion3();
            case "4":
                return pregunta.getOpcion4();
            case "5":
                return pregunta.getOpcion5();
            case "6":
                return pregunta.getOpcion6();
            default:
                return null;
        }
    }
}
