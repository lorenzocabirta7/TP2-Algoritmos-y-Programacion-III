package main;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoPenalidad extends Pregunta {
    private String enunciado;

    private ArrayList<Respuesta> respuestas;

    public PreguntaVerdaderoFalsoPenalidad(String pregunta, ArrayList<Respuesta> respuestas) {
        super(pregunta, respuestas);
        enunciado = pregunta;
        this.respuestas = respuestas;

    }

}
