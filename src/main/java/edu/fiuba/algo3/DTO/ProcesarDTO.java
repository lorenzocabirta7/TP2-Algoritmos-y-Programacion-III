package edu.fiuba.algo3.DTO;

import edu.fiuba.algo3.modelo.ModoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;

public class ProcesarDTO {

   public ArrayList<Pregunta> procesarPreguntas(PreguntaDTO[] listaPreguntas) {

       ArrayList<Pregunta> preguntas = new ArrayList<>();
       for (PreguntaDTO pregunta : listaPreguntas) {


           ArrayList<Respuesta> respuestasPregunta;
           TipoDePreguntaDTO GeneradorFormaDePuntaje = new TipoDePreguntaDTO();
           if (pregunta.getTipo().equals("Group Choice")) { //los groupchoice se tienen que procesar de otra forma que el resto de las preguntas
               respuestasPregunta = procesarPreguntasGroupChoice(pregunta);
           } else {
               respuestasPregunta = procesarPreguntasNormales(pregunta);
           }
           TipoDePregunta unTipoDePregunta = GeneradorFormaDePuntaje.TipoDePuntuacion(pregunta);
           Pregunta preguntaNueva = new Pregunta(pregunta.getPregunta(), pregunta.getTema(), respuestasPregunta,unTipoDePregunta);
           preguntas.add(preguntaNueva);
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
            String opcion = ObtenerOpcionPorPosicion(pregunta, indice);
            if (opcion != null) {
                if (indicesDeRespuestasCorrectas.contains(indice)) { //si la respuesta es de tipo correcta.
                    Respuesta respuestaCorrecta = new RespuestaCorrecta(opcion, String.valueOf(indicesDeRespuestasCorrectas.indexOf(indice)+ 1));
                    respuestasTotales.add(respuestaCorrecta);
                } else {
                    TipoDePreguntaDTO tipoDePenalidad = new TipoDePreguntaDTO();
                    Respuesta respuestaIncorrecta = new RespuestaIncorrecta(opcion);
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
               String unaRespuesta = ObtenerOpcionPorPosicion(pregunta, indice);
               Respuesta respuesta = new RespuestaCorrecta(unaRespuesta, grupoEspecifico);
               respuestas.add(respuesta);
           }
       }
       return respuestas;
   }


    private static String ObtenerOpcionPorPosicion(PreguntaDTO pregunta, String numeroOpcion) {
        switch (numeroOpcion) {
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
                return null; //lanzar excepcion
        }
    }
}
