package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Anulador.Anulador;
import edu.fiuba.algo3.modelo.Anulador.AnuladorPenalidad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;

import java.util.ArrayList;

public abstract class PuntuarConPenalidad implements FormaDePuntuar {
    protected ArrayList<Jugador> jugadoresQueUsaronAnulador = new ArrayList<Jugador>();

    protected Anulador anulador = new AnuladorPenalidad();
    public void agregarJugadorQueUsoAnulador(Jugador jugador){
        this.jugadoresQueUsaronAnulador.add(jugador);
    }
    public void agregarJugadorQueUsoExclusividad(Jugador jugador,Pregunta pregunta) throws ExclusividadInvalida {
        throw new ExclusividadInvalida("La Exclusividad, solo se puede Activar en Preguntas sin Penalidad");
    }
}
