package main;


import java.util.ArrayList;
import java.util.List;

//Asigna un punto a cada jugador que responda con la opción correcta
public class PreguntaVerdaderoFalsoClasico extends Pregunta {

    private String enunciado;

    private ArrayList<Respuesta> respuestas;

    public PreguntaVerdaderoFalsoClasico(String pregunta, ArrayList<Respuesta> respuestas) {
        super(pregunta, respuestas);
        enunciado = pregunta;
        this.respuestas = respuestas;

    }


}
