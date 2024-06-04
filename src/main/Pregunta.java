package main;

import java.util.ArrayList;

public abstract class Pregunta {

    private String enunciado;
    private ArrayList<Respuesta> respuestas;

    public Pregunta(String enunciado, ArrayList<Respuesta> respuestasPosibles) {
        this.enunciado = enunciado;
        this.respuestas = respuestasPosibles;
    }

    public void puntuar(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta: respuestas) {
            respuesta.actualizarPuntaje(1);
        }
    }

    public ArrayList<Respuesta> respuestasPosibles(){
        return this.respuestas;
    }


    public String getEnunciado() {
        return this.enunciado;
    }

}


