package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public class Pregunta {

    private String enunciado;
    private ArrayList<Respuesta> respuestas;
    private FormaDePuntuar unaFormaDePuntuar;


    public Pregunta(String enunciado, ArrayList<Respuesta> respuestasPosibles, FormaDePuntuar tipoDePregunta) {
        this.enunciado = enunciado;
        this.respuestas = respuestasPosibles;
        this.unaFormaDePuntuar = tipoDePregunta;
    }

    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unjugador){
        unaFormaDePuntuar.puntuar(respuestas, unjugador);
    }

    public ArrayList<Respuesta> respuestasPosibles(){
        return this.respuestas;
    }


    public String getEnunciado() {
        return this.enunciado;
    }

}


