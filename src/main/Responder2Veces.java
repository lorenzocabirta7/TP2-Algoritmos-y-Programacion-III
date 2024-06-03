package main;

import java.util.ArrayList;

public class Responder2Veces implements FormaRespuesta{

    @Override
    public ArrayList<Respuesta> responder(Pregunta pregunta) {
        ArrayList<Respuesta> respuestasPosibles = pregunta.respuestasPosibles();
        ArrayList<Respuesta> respuestaElegidas = elegirRespuestas(respuestasPosibles);
        return respuestaElegidas;
    }

    private ArrayList<Respuesta> elegirRespuestas(ArrayList<Respuesta> respuestas) {
        ArrayList<Respuesta> respuestasElegidas = new ArrayList<>();
        respuestasElegidas.add(respuestas.getFirst());
        respuestasElegidas.add(respuestas.get(1));
        return respuestasElegidas;
    }
}
