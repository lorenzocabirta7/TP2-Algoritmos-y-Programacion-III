package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.Anulador.Anulador;
import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.ModoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Pregunta {
    private final String enunciado;
    private final String tema;
    private final ArrayList<Respuesta> respuestas;
    private TipoDePregunta tipoDePregunta;
    private ArrayList<Jugador> jugadoresQueRespondieronCorrectamente = new ArrayList<Jugador>();
    private HashMap<Jugador, ArrayList<Respuesta>> jugadoresYRespuestas = new HashMap<>();
    private Anulador anulador = new Anulador();
    private Exclusividad exclusividad = new Exclusividad();
    private int puntosPorRespuestaCorrecta = 1;
    private int cantidadDeRespuestasCorrectas;

    public Pregunta(String enunciado, String tema, ArrayList<Respuesta> respuestasPosibles, TipoDePregunta tipoDePregunta) {
        this.enunciado = enunciado;
        this.tema = tema;
        this.respuestas = respuestasPosibles;
        this.tipoDePregunta = tipoDePregunta;
        //respuestasPosibles.stream().filter(respuesta -> respuesta.EsCorrecta(respuesta)).count())
    }

    public ArrayList<Respuesta> getRespuestasCorrectas() {
        return respuestas.stream().filter(respuesta -> respuesta.EsCorrecta(respuesta)).collect(Collectors.toCollection(ArrayList::new));
    }

    public int cantidadDeRespuestasCorrectas(){
        return (int) respuestas.stream().filter(respuesta -> respuesta.EsCorrecta(respuesta)).count();
    }

    public void confirmarRespuesta(ArrayList<Respuesta> respuestas, Jugador jugador) {
        int respuestasCorrectas = 0;
        jugadoresYRespuestas.put(jugador,respuestas);
        for (Respuesta delJugador : respuestas) {
            String enunciadoDelJugador =  delJugador.getRespuesta();
            for (Respuesta dePregunta : respuestas) {
                if (dePregunta.getRespuesta().equals(enunciadoDelJugador)) {
                    if (delJugador.EsCorrecta(dePregunta)){
                        respuestasCorrectas++;
                    }
                }
            }
        }
        if (respuestasCorrectas == cantidadDeRespuestasCorrectas()) {
            jugadoresQueRespondieronCorrectamente.add(jugador);
        }

    }

    public void puntuarJugadores(){
        for (Jugador jugador : jugadoresYRespuestas.keySet()) {

            ArrayList<Respuesta> respuestasDelJugador = jugadoresYRespuestas.get(jugador);
            int puntaje = tipoDePregunta.actualizarPuntaje(puntosPorRespuestaCorrecta, respuestasDelJugador, respuestas);
            puntaje = anulador.anular(puntaje,jugador);
            puntaje = exclusividad.excluir(puntaje,jugador,jugadoresQueRespondieronCorrectamente);
            jugador.modificarPuntaje(puntaje);
        }

        anulador.desactivar();
        exclusividad.desactivar();
    }


    // Getters
    public String getEnunciado() {
        return enunciado;
    }

    public String getTema() {
        return tema;
    }

    public ArrayList<Respuesta> respuestasPosibles() {
        return respuestas;
    }

    public void jugadorUsoAnulador(Jugador jugador) {
        anulador.activar(jugador);
    }

    public void activarExclusividad(Jugador jugador) {
        exclusividad.activar(jugador);
    }
}

