package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;
import main.Anulador.*;
import java.util.ArrayList;

public class Pregunta {

    private String enunciado;
    private ArrayList<Respuesta> respuestas;
    private ArrayList<Jugador> jugaodoresQueUsaronAnulador;
    private GestorAnulador gestor;
    private FormaDePuntuar unaFormaDePuntuar;


    public Pregunta(String enunciado, ArrayList<Respuesta> respuestasPosibles, FormaDePuntuar tipoDePregunta, GestorAnulador tipoAnulador) {
        this.enunciado = enunciado;
        this.respuestas = respuestasPosibles;
        this.unaFormaDePuntuar = tipoDePregunta;
        this.jugaodoresQueUsaronAnulador =  new ArrayList<>();
        this.gestor = tipoAnulador;
    }

    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unjugador){
        int puntosObtenidos = this.unaFormaDePuntuar.puntuar(respuestas);
        puntosObtenidos = this.gestor.puntosLuegoDeEvaluacion(puntosObtenidos,this.jugaodoresQueUsaronAnulador,unjugador);
        unjugador.modificarPuntaje(puntosObtenidos);
    }

    public ArrayList<Respuesta> respuestasPosibles(){
        return this.respuestas;
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public void jugadorUsoAnulador(Jugador jugador) {
        this.jugaodoresQueUsaronAnulador.add(jugador);
        this.gestor.activar();
    }

    public void anulate(){this.gestor.activar();}
}


