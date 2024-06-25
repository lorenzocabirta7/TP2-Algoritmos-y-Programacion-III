package edu.fiuba.algo3.modelo.Respuestas.Penalidad;

public class PenalidadConPenalidad implements TipoDePenalidad {
    @Override
    public int actualizarPuntaje(int puntaje){
        return (puntaje * -1);
    };
}
