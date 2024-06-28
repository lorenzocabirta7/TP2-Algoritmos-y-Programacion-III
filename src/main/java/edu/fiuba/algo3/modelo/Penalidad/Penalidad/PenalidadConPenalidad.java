package edu.fiuba.algo3.modelo.Penalidad.Penalidad;

public class PenalidadConPenalidad implements TipoDePenalidad {
    @Override
    public int penalizarPuntaje(int puntaje){
        return (puntaje * -1);
    };
}
