package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Jugador;

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
        int puntosObtenidos = this.unaFormaDePuntuar.puntuar(respuestas,unjugador);
        unjugador.modificarPuntaje(puntosObtenidos);
    }

    public ArrayList<Respuesta> respuestasPosibles(){
        return this.respuestas;
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public void jugadorUsoAnulador(Jugador jugador) {
        unaFormaDePuntuar.agregarJugadorQueUsoAnulador(jugador);
    }



    @Override
    public String toString() {
        return "Pregunta {" +
                "enunciado = '" + enunciado + '\'' +
                "Respuestas = " + respuestas +
                ", FormaDePuntuar = '" + unaFormaDePuntuar + '\'' +
                '}';
    }
}


