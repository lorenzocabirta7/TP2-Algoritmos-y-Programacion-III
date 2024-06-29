package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.modificadores.*;
import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.Exclusividad.*;

import java.util.ArrayList;

public class Jugador {

    private final String nombre;
    private final Puntaje puntos;
    private final MultiplicadorPorDos multiplicadorPorDos;
    private final MultiplicadorPorTres multiplicadorPorTres;
    private final GestorAnulador gestorAnulador;
    private final GestorExclusividad gestorExclusividad;
    private ArrayList<Respuesta> respuestasDelJugador;
    private String ordenParcialRespuestas;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.puntos = new Puntaje();
        this.multiplicadorPorDos = new MultiplicadorPorDos();
        this.multiplicadorPorTres = new MultiplicadorPorTres();
        this.respuestasDelJugador = new ArrayList<>();
        this.gestorAnulador = new GestorAnulador();
        this.gestorExclusividad = new GestorExclusividad();
        this.ordenParcialRespuestas = "1";
    }

    public void responder(Pregunta pregunta, Respuesta respuestaElegida) { //las preguntas que reciba aca deben ser de la interfaz Pregunta
        respuestasDelJugador.add(respuestaElegida);
    }

    public void modificarPuntaje(int puntajePregunta) {
        int puntajeModificado = this.multiplicadorPorDos.modificarPuntaje(puntajePregunta);
        puntajeModificado = this.multiplicadorPorTres.modificarPuntaje(puntajeModificado);
        this.puntos.agregarPuntaje(puntajeModificado);

    }

    public int obtenerPuntos() {
        return this.puntos.getPuntaje();
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void activarDuplicadorDePuntaje() throws edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException {
        this.multiplicadorPorDos.activar();
    }

    public void activarTriplicadorDePuntaje() throws  edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException {
        this.multiplicadorPorTres.activar();
    }

    public ArrayList<Respuesta> obtenerRespuestas(){
        return this.respuestasDelJugador;
    }

    public void confirmarRespuesta(Pregunta pregunta){
        pregunta.confirmarRespuesta(respuestasDelJugador,this);
        this.resetRespuestas();
    }

    public void activarAnuladorDePuntaje(Pregunta pregunta) throws edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez {
        this.gestorAnulador.gestarActivacion(pregunta,this);
    }

    public void activarExclusividad(Pregunta pregunta) throws edu.fiuba.algo3.modelo.exceptions.ExclusividadSeUsaMasdeDosVeces, edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida {

        this.gestorExclusividad.gestarActivacion(pregunta,this);
    }

    public void resetRespuestas(){
        this.respuestasDelJugador = new ArrayList<>();
        this.ordenParcialRespuestas = "1";
    }

    public String obtenerOrdenParcial(){
        String ordenActual = ordenParcialRespuestas;
        int ordenNumerico = Integer.parseInt(this.ordenParcialRespuestas);
        ordenNumerico = ordenNumerico + 1;
        ordenParcialRespuestas = ordenNumerico + "";
        return ordenActual;
    }
}
