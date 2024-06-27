package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;

import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private String tema;
    private ArrayList<Respuesta> respuestas;
    private FormaDePuntuar unaFormaDePuntuar;
    private ArrayList<Jugador> jugadoresQueRespondieronCorrectamente = new ArrayList<Jugador>();


    public Pregunta(String enunciado, String tema, ArrayList<Respuesta> respuestasPosibles, FormaDePuntuar tipoDePregunta) {
        this.enunciado = enunciado;
        this.tema = tema;
        this.respuestas = respuestasPosibles;
        this.unaFormaDePuntuar = tipoDePregunta;

    }

    public ArrayList<Respuesta> getRespuestaCorrecta(){
        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<>();
        for (Respuesta respuesta : respuestas) {
            if (respuesta.EsCorrecta(respuesta)){
                respuestasCorrectas.add(respuesta);
            }
        }
        return respuestasCorrectas;
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

    public void activarExclusividad(Jugador jugador) throws ExclusividadInvalida  {
        unaFormaDePuntuar.agregarJugadorQueUsoExclusividad(jugador, this);

    }

    public void confirmarRespuesta(ArrayList<Respuesta> respuestasDelJugador, Jugador jugador) {
            //boolean jugadorRespondioCorrectamente = true;
            //for (Respuesta respuesta : respuestasDelJugador) {
            //    for (Respuesta respuestaCorrecta : this.getRespuestaCorrecta()) {
            //        if (respuestaCorrecta.getRespuesta().equals(respuesta.getRespuesta())) {
            //            if (!respuesta.EsCorrecta(respuestaCorrecta)){
            //                jugadorRespondioCorrectamente = false;
            //            }
            //        }
            //    }
            //}
            //if (jugadorRespondioCorrectamente){
            //    jugadoresQueRespondieronCorrectamente.add(jugador);
            //}
        //this.unaFormaDePuntuar.respondioBien(respuestasDelJugador, jugador);

    }
}

