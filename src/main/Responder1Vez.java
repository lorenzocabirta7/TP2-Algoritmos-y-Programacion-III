package main;

import java.util.ArrayList;

public class Responder1Vez implements FormaRespuesta{
    @Override
    public ArrayList<Respuesta> responder(Pregunta pregunta) {
        ArrayList<Respuesta> respuestasPosibles = pregunta.respuestasPosibles();
        ArrayList<Respuesta> respuestaElegida = elegirRespuesta(respuestasPosibles);
        return respuestaElegida;
    }

    private ArrayList<Respuesta> elegirRespuesta(ArrayList<Respuesta> respuestas) {
        ArrayList<Respuesta> respuestasElegidas = new ArrayList<>();
        respuestasElegidas.add(respuestas.getFirst());
        return respuestasElegidas;
    }
}


