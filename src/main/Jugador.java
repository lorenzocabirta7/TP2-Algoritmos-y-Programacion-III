package main;

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

    private Respuesta elegirRespuesta(ArrayList<Respuesta> respuestas) {
        Respuesta respuestaElegida = respuestas.get(0);
        return respuestaElegida;
    }

    public void modificarPuntaje(int puntajePregunta) {
        //cuando implementemos la logica de los multiplicaodres creo que iria acá
        this.puntos += puntajePregunta;
    }

    public int obtenerPuntos() {
        return this.puntos;
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}
