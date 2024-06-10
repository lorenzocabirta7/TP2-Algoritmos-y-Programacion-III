package main.preguntas;

import main.TipoDePenalidad;

public class PenalidadConPenalidad implements TipoDePenalidad {
    @Override
    public int actualizarPuntaje(int puntaje){
        return (puntaje * -1);
    };
}
