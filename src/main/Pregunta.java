package main;

import java.util.ArrayList;

public abstract class Pregunta {

    private String enunciado;
    private ArrayList<Respuesta> respuestas;

    public Pregunta(String enunciado, ArrayList<Respuesta> respuestasPosibles) {
        this.enunciado = enunciado;
        this.respuestas = respuestasPosibles;
    }

    public abstract void puntuar(ArrayList<Respuesta> respuestas, Jugador unjugador);

    public ArrayList<Respuesta> respuestasPosibles(){
        return this.respuestas;
    }


    public String getEnunciado() {
        return this.enunciado;
    }

    protected ArrayList<Respuesta> obtenerRespuestasCorrectas() {

        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<>();

        for (Respuesta respuestaPosible : respuestas) {
            if (respuestaPosible.EsCorrecta()) {
                respuestasCorrectas.add(respuestaPosible);
            }
        }
        return respuestasCorrectas;
    }
}


