package main;


import java.util.ArrayList;

public interface Pregunta {
    ArrayList<Respuesta> respuestasPosibles();

   void puntuar(ArrayList<Respuesta> respuesta);
}

