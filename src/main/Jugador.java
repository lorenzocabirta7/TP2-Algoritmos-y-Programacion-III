package main;

import main.exceptions.ModificadorSeUsaMasDeUnaVezException;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntos;
    //private modificador;
    private MultiplicadorPorDos multiplicadorPorDos;

    private ArrayList<Respuesta> respuestasDelJugador;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.puntos = 0;
        multiplicadorPorDos = new MultiplicadorPorDos();
        respuestasDelJugador = new ArrayList<>();
        //siempre inicializamos con la idea de responder primero una pregunta de verdadero/falso
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


    public ArrayList<Respuesta> obtenerRespuestas(){
        return this.respuestasDelJugador;
    }

    public void activarAnuladorDePuntaje() {}
}
