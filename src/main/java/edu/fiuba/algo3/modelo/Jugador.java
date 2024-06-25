package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.modificadores.*;
import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.Exclusividad.*;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntos;
    private MultiplicadorPorDos multiplicadorPorDos;
    private MultiplicadorPorTres multiplicadorPorTres;
    private GestorAnulador gestorAnulador;
    private GestorExclusividad gestorExclusividad;
    private ArrayList<Respuesta> respuestasDelJugador;
    private String ordenParcialRespuestas;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.puntos = 0;
        this.multiplicadorPorDos = new MultiplicadorPorDos();
        this.multiplicadorPorTres = new MultiplicadorPorTres();
        this.respuestasDelJugador = new ArrayList<>();
        this.gestorAnulador = new GestorAnulador();
        this.gestorExclusividad = new GestorExclusividad();

    }

    public void responder(Pregunta pregunta, Respuesta respuestaElegida) { //las preguntas que reciba aca deben ser de la interfaz Pregunta
        respuestasDelJugador.add(respuestaElegida);
    }

    public void modificarPuntaje(int puntajePregunta) {
        int puntajeModificado = multiplicadorPorDos.modificarPuntaje(puntajePregunta);
        puntajeModificado = multiplicadorPorTres.modificarPuntaje(puntajeModificado);
        this.puntos += puntajeModificado;
    }

    public int obtenerPuntos() {
        return this.puntos;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void activarDuplicadorDePuntaje() throws ModificadorSeUsaMasDeUnaVezException {
        this.multiplicadorPorDos.activar();
    }

    public void activarTriplicadorDePuntaje() throws ModificadorSeUsaMasDeUnaVezException {
        this.multiplicadorPorTres.activar();
    }

    public ArrayList<Respuesta> obtenerRespuestas(){
        return this.respuestasDelJugador;
    }

    public void confirmarRespuesta(Pregunta pregunta){
        pregunta.puntuar(respuestasDelJugador, this);
    }

    public void activarAnuladorDePuntaje(Pregunta pregunta) throws AnuladorSeUsaMasDeUnaVez {
        this.gestorAnulador.gestarActivacion(pregunta,this);
    }

    public void activarExclusividad(Pregunta pregunta) throws ExclusividadSeUsaMasdeDosVeces {
        this.gestorExclusividad.gestarActivacion(pregunta,this);
    }

    public void ResetRespuestas(){
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
