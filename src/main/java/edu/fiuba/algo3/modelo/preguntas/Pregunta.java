package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.Anulador.Anulador;
import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.ModoDePregunta.TipoDePregunta;
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
    //private HashMap<Jugador, ArrayList<Respuesta>> jugadoresYRespuestas = new HashMap<>();
    private Anulador anulador = new Anulador();
    private Exclusividad exclusividad = new Exclusividad();
    private int puntosPorRespuestaCorrecta = 1;
    private int cantidadDeRespuestasCorrectas;
    private ArrayList<Jugador> jugadores;

    public Pregunta(String enunciado, String tema, ArrayList<Respuesta> respuestasPosibles, TipoDePregunta tipoDePregunta) {
        this.enunciado = enunciado;
        this.tema = tema;
        this.respuestas = respuestasPosibles;
        this.tipoDePregunta = tipoDePregunta;
        this.jugadores = new ArrayList<>();
        //cantidadDeRespuestasCorrectas = (int) respuestasPosibles.stream().filter(respuesta -> respuesta.EsCorrecta(respuesta)).count())
    }

    public ArrayList<Respuesta> getRespuestasCorrectas() {
        return respuestas.stream().filter(respuesta -> respuesta.EsCorrecta(respuesta)).collect(Collectors.toCollection(ArrayList::new));
    }

    public int cantidadDeRespuestasCorrectas(){
        return (int) respuestas.stream().filter(respuesta -> respuesta.EsCorrecta(respuesta)).count();
    }

    public void confirmarRespuesta(ArrayList<Respuesta> respuestas, Jugador jugador) {
        int respuestasCorrectas = 0;
        //jugadoresYRespuestas.put(jugador,jugador.obtenerRespuestas()); // Agrego al jugador con sus Respuestas
        jugadores.add(jugador);
        for (Respuesta respuestaDelJugador : jugador.obtenerRespuestas()) {

            String enunciadoDelJugador =  respuestaDelJugador.getRespuesta(); //obtengo el enunciado

            for (Respuesta respuestasDeLaPregunta : this.respuestas) {
                if (respuestasDeLaPregunta.getRespuesta().equals(enunciadoDelJugador)) {
                    if (respuestaDelJugador.EsCorrecta(respuestasDeLaPregunta)){
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
        System.out.println("Hay " + jugadores.size() + " jugadores.");
        for (Jugador jugador : jugadores) {

            //ArrayList<Respuesta> respuestasDelJugador = jugadoresYRespuestas.get(jugador);
            int puntaje = tipoDePregunta.actualizarPuntaje(puntosPorRespuestaCorrecta, jugador.obtenerRespuestas(), respuestas);
            System.out.println("el jugador: " + jugador.obtenerNombre() + "respondio esto segun el jugador: " + jugador.obtenerRespuestas());
            //System.out.println("el jugador: " + jugador.obtenerNombre() + "respondio esto segun el diccionario: " + jugadoresYRespuestas.get(jugador));
            puntaje = anulador.anular(puntaje,jugador);
            puntaje = exclusividad.excluir(puntaje,jugador,jugadoresQueRespondieronCorrectamente);
            jugador.modificarPuntaje(puntaje);
            System.out.println("puntaje de: " + jugador.obtenerNombre() + " es: " + puntaje);
        }

        anulador.desactivar();
        exclusividad.desactivar();
    }

    // Getters
    public String getEnunciado() {
        return enunciado;
    }

    public String getTipoDePregunta() {
        String mensaje = "Pregunta de Tipo: ";
        return this.tipoDePregunta.getTipoDePregunta(mensaje);
    }

    public ArrayList<Jugador> getJugadoresQueRespondieronCorrectamente() {
        return jugadoresQueRespondieronCorrectamente;
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

    public boolean esGroupChoice () {
        return tipoDePregunta.EsDeGroupChoice();
    }

    public boolean esOrderChoice() {
        return tipoDePregunta.EsDeOrderedChoice();
    }

    public boolean esDeVerdaderoFalso() {
        return tipoDePregunta.EsDeVerdaderoFalso();
    }

    public boolean esDeMultipleChoice() {
        return tipoDePregunta.EsDeMultipleChoice();
    }

}

