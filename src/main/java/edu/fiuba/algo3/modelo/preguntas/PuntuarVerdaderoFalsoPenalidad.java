package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Anulador.*;


import edu.fiuba.algo3.modelo.Anulador.*;

public class PuntuarVerdaderoFalsoPenalidad extends PuntuarVerdaderoFalso {
    public PuntuarVerdaderoFalsoPenalidad(){
        this.anulador = new AnuladorPenalidad();
    }
}
