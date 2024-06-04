package main;

import java.util.ArrayList;

public class PreguntaMultipleChoicePenalidad extends Pregunta{
    private String enunciado;

    private ArrayList<Respuesta> respuestas;

    public PreguntaMultipleChoicePenalidad(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
        this.enunciado = enunciado;
        this.respuestas = respuestas;
    }

}
