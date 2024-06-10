package main;

import java.util.ArrayList;

public abstract class Pregunta {

    protected String enunciado;
    protected ArrayList<Respuesta> respuestas;
    protected ArrayList<Jugador> jugaodoresQueUsaronAnulador;
    protected GestorAnulador gestor;

    public Pregunta(String enunciado, ArrayList<Respuesta> respuestasPosibles) {
        this.enunciado = enunciado;
        this.respuestas = respuestasPosibles;
        this.jugaodoresQueUsaronAnulador =  new ArrayList<>();
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
        this.gestor.activar();
    }
    public void anulate(){this.gestor.activar();}
}


