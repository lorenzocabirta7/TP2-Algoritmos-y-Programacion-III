package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Anulador.Anulador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez;
import edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException;
import edu.fiuba.algo3.modelo.modificadores.MultiplicadorPorDos;
import edu.fiuba.algo3.modelo.modificadores.MultiplicadorPorTres;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntos;
    //private modificador;
    private MultiplicadorPorDos multiplicadorPorDos;
    private MultiplicadorPorTres multiplicadorPorTres;
    private Anulador anuladorDePuntaje;
    private ArrayList<Respuesta> respuestasDelJugador;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.puntos = 0;
        this.multiplicadorPorDos = new MultiplicadorPorDos();
        this.multiplicadorPorTres = new MultiplicadorPorTres();
        this.respuestasDelJugador = new ArrayList<>();
        this.anuladorDePuntaje = new Anulador();
        //siempre inicializamos con la idea de responder primero una pregunta de verdadero/falso
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
        pregunta.jugadorUsoAnulador(this);
        this.anuladorDePuntaje.activar();
    }
}
