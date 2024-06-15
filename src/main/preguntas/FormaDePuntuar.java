package main.preguntas;

import main.Anulador.GestorAnulador;
import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public interface FormaDePuntuar {
    public int puntuar(ArrayList<Respuesta> respuestas);
}
