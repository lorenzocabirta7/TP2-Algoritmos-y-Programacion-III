package edu.fiuba.algo3.modelo;

import com.google.gson.Gson;
import edu.fiuba.algo3.modelo.DTO.PreguntaDTO;
import edu.fiuba.algo3.modelo.DTO.ProcesarDTO;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class maain {
    public static void main(String[] args) {
        Gson gson = new Gson();


        try (Reader readerPregunta = new InputStreamReader(maain.class.getResourceAsStream("/preguntas.json"))) {

            PreguntaDTO[] listaPreguntas = gson.fromJson(readerPregunta, PreguntaDTO[].class);

            ProcesarDTO procesador = new ProcesarDTO();

            ArrayList<Pregunta> listaPreguntasProcesadas = procesador.procesarPreguntas(listaPreguntas);


            System.out.println("Preguntas:");
            for (Pregunta pregunta : listaPreguntasProcesadas) {
                System.out.println(pregunta.getEnunciado() + " " + pregunta.getTipoDePregunta());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}