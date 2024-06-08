package main;

import java.util.ArrayList;

public abstract class Pregunta {

    protected String enunciado;
    protected ArrayList<Respuesta> respuestas;
    protected boolean anulada;
    protected ArrayList<Jugador> jugaodoresQueUsaronAnulador;

    public Pregunta(String enunciado, ArrayList<Respuesta> respuestasPosibles) {
        this.enunciado = enunciado;
        this.respuestas = respuestasPosibles;
        this.jugaodoresQueUsaronAnulador =  new ArrayList<>();
        this.anulada = false;
    }

    public abstract void puntuar(ArrayList<Respuesta> respuestas, Jugador unjugador);

    public ArrayList<Respuesta> respuestasPosibles(){
        return this.respuestas;
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    protected ArrayList<Respuesta> obtenerRespuestasCorrectas() {

        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<>();

        for (Respuesta respuestaPosible : respuestas) {
            if (respuestaPosible.EsCorrecta()) {
                respuestasCorrectas.add(respuestaPosible);
            }
        }
        return respuestasCorrectas;
    }
    public void jugadorUsoAnulador(Jugador jugador) {
        this.jugaodoresQueUsaronAnulador.add(jugador);
        this.anulate();
    }
    public void anulate(){this.anulada = true;}
}


