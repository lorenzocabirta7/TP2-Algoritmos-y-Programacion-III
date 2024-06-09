package main;

import main.exceptions.AnuladorSeUsaMasDeUnaVez;
import main.exceptions.ModificadorSeUsaMasDeUnaVezException;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntos;
    private MultiplicadorPorDos multiplicadorPorDos;
    private Anulador anuladorDePuntaje;
    private ArrayList<Respuesta> respuestasDelJugador;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.puntos = 0;
        this.multiplicadorPorDos = new MultiplicadorPorDos();
        this.respuestasDelJugador = new ArrayList<>();
        this.anuladorDePuntaje = new Anulador();
    }

    public  void responder(Pregunta pregunta, Respuesta respuestaElegida) { //las preguntas que reciba aca deben ser de la interfaz Pregunta
        respuestasDelJugador.add(respuestaElegida);
    }

    public void modificarPuntaje(int puntajePregunta) {
        int puntajeModificado = multiplicadorPorDos.modificarPuntaje(puntajePregunta);
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

    public void activarAnuladorDePuntaje(Pregunta pregunta) throws AnuladorSeUsaMasDeUnaVez {
        pregunta.jugadorUsoAnulador(this);
        this.anuladorDePuntaje.activar();
    }

    public ArrayList<Respuesta> obtenerRespuestas(){
        return this.respuestasDelJugador;
    }
}
