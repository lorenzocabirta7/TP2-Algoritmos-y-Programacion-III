package main;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico implements Pregunta{
    private String enunciado;

    private ArrayList<Respuesta> respuestas;

    public PreguntaMultipleChoiceClasico(String enunciado, ArrayList<Respuesta> respuestas){
        this.enunciado = enunciado;
        this.respuestas = respuestas;
    }

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

