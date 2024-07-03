package edu.fiuba.algo3.modelo;

import com.google.gson.Gson;
import edu.fiuba.algo3.modelo.DTO.PreguntaDTO;
import edu.fiuba.algo3.modelo.DTO.ProcesarDTO;
import edu.fiuba.algo3.modelo.exceptions.YaJugaronTodosLosJugadores;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Observable;

import java.util.Random;


public class Modelo extends Observable {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Pregunta> preguntas;
    private Pregunta preguntaActual;
    private Jugada jugadaActual;


    public Modelo() {
        this.jugadores = new ArrayList<>();
        this.procesarPreguntas();
        this.jugadaActual = iniciarJugada();
    }

    public Jugada iniciarJugada(){
        return new Jugada(jugadores, preguntaActual);
    }

    public void agregarJugador(String nombreJugador) {
        jugadores.add(new Jugador(nombreJugador));
    }

    private void procesarPreguntas(){
        preguntas = new ArrayList<>();

        Gson gson = new Gson();


        try (Reader readerPregunta = new InputStreamReader(maain.class.getResourceAsStream("/preguntas.json"))) {

            PreguntaDTO[] listaPreguntas = gson.fromJson(readerPregunta, PreguntaDTO[].class);

            ProcesarDTO procesador = new ProcesarDTO();

            this.preguntas = procesador.procesarPreguntas(listaPreguntas);

            this.preguntaActual = this.BuscarPregunta();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Pregunta BuscarPregunta() {
        Random random = new Random();

        int indiceRandom = random.nextInt(preguntas.size());

        return preguntas.get(indiceRandom);
    }

    public Pregunta ConseguirPregunta(){
        return preguntaActual;
    }

    public Jugador conseguirJugador(){
        return jugadaActual.conseguirJugador();
    }

    public ArrayList<String> ConseguirTodosLosJugadores(){
        ArrayList<String> jugadoresADevolver = new ArrayList<>();
        for (Jugador jugador : this.jugadores) {
            jugadoresADevolver.add(jugador.obtenerNombre());
        }
        return jugadoresADevolver;
    }

    public ArrayList<Integer> ConseguirTodosLosPuntajes(){
        ArrayList<Integer> puntajesADevolver = new ArrayList<>();
        for (Jugador jugador : this.jugadores) {
            puntajesADevolver.add(jugador.obtenerPuntos());
        }
        return puntajesADevolver;
    }

    public void confirmarRespuestas(){
        jugadaActual.confirmarRespuestas();
    }

    public void SiguientePregunta(){
        this.preguntaActual = BuscarPregunta();
        this.jugadaActual = iniciarJugada();
        setChanged();
        notifyObservers("Siguiente Pregunta");
    }

    public void SiguienteJugador()  throws YaJugaronTodosLosJugadores{
            jugadaActual.siguienteJugador();
            setChanged();
            notifyObservers("Siguiente Jugador");

    }

    public void puntuarRespuestas() {
        jugadaActual.puntuarTodosLosJugadores(preguntaActual);
    }
}
