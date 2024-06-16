package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public interface FormaDePuntuar {
    public int puntuar(ArrayList<Respuesta> respuestas);
}
