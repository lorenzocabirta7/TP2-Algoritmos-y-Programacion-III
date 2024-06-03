package main;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoPenalidad implements Pregunta{
    private String enunciado;

    private ArrayList<Respuesta> respuestas;



    public PreguntaVerdaderoFalsoPenalidad(String pregunta, ArrayList<Respuesta> respuestas) {
        enunciado = pregunta;
        this.respuestas = respuestas;

    }


    //respuestasDeVerdaderoFalsoClasico deberia poder responder lo mismo que Respuesta, porque hereda de ella
    @Override
    public void puntuar(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta: respuestas) {
                respuesta.actualizarPuntaje(1);
        }
    }

    @Override
    public ArrayList<Respuesta> respuestasPosibles(){
        return respuestas;
    }


    public String getEnunciado() {
        return enunciado;
    }
}
