package main;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntos;


    public Jugador(String nombreJugador) {
        this.nombre = nombreJugador;
        this.puntos = 0;
    }



    public void responder(Pregunta pregunta, ArrayList<Respuesta> respuestas) {
        Respuesta respuestaElegida = this.elegirRespuesta(respuestas);
        respuestaElegida.fueElegidaPor(this);
    }

    private Respuesta elegirRespuesta(ArrayList<Respuesta> respuestas) {
        // cuando implementemos javaFx para que el usuario eliga
        // creo que la logica va a estar aca
        return respuestas.get(1);
    }

    public void aumentar_puntaje(int puntajePregunta) {
        //cuando implementemos la logica de los multiplicaodres creo que iria acá
        this.puntos += puntajePregunta;
    }
}
