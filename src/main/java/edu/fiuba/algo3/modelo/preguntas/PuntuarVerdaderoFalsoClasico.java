package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Anulador.*;

//Asigna un punto a cada jugador que responda con la opción correcta
public class PuntuarVerdaderoFalsoClasico extends PuntuarVerdaderoFalso {
    public PuntuarVerdaderoFalsoClasico(){
        this.anulador = new AnuladorClasico();
    }
}
