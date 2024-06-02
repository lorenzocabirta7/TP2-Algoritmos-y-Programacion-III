package main;


import java.util.ArrayList;
import java.util.List;

//Asigna un punto a cada jugador que responda con la opción correcta
public class PreguntaVerdaderoFalsoClasico implements Pregunta {

    private String enunciado;

    private ArrayList<Respuesta> respuestas;



    public PreguntaVerdaderoFalsoClasico(String pregunta, ArrayList<Respuesta> respuestas) {
        enunciado = pregunta;
        this.respuestas = respuestas;
        //respuestaCorrecta = respuesta;

    }


    //respuestasDeVerdaderoFalsoClasico deberia poder responder lo mismo que Respuesta, porque hereda de ella
    public void puntuar(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta: respuestas) {
            if (respuesta.esCorrecta()) {
                respuesta.actualizarPuntaje(1);
            }
        }
    }

    public ArrayList<Respuesta> respuestasPosibles(){
        return respuestas;
    }

}
