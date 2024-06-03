package main;

import main.exceptions.ModificadorSeUsaMasDeUnaVezException;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntos;
    //private modificador;
    private MultiplicadorPorDos multiplicadorPorDos;

    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.puntos = 0;
        multiplicadorPorDos = new MultiplicadorPorDos();
    }

    public  void responder(Pregunta pregunta) { //las preguntas que reciba aca deben ser de la interfaz Pregunta
        ArrayList<Respuesta> respuestas = pregunta.respuestasPosibles();
        Respuesta respuestaElegida = this.elegirRespuesta(respuestas);
        respuestaElegida.setJugador(this);
    }

    //podriamos usar el patron strategy para que cada pregunta que llega cambie este metodo, pasando el metodo
    //a ser un atributo de la clase jugador y que tenga las clases que pueden entender este mensaje responder
    private Respuesta elegirRespuesta(ArrayList<Respuesta> respuestas) {
        return respuestas.getFirst();
    }


    //Preguntar si esta bien ubicado este metodo. De quien es la responsabilidad de actualizar el puntaje
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
}
