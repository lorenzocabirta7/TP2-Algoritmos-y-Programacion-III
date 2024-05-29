package Main;

import java.util.ArrayList;
import java.util.List;


//Asigna un punto a cada jugador que responda con la opción correcta
public class VerdaderoFalsoClasico implements Pregunta {

    private String enunciado;

    private Respuesta respuestaCorrecta;


    public VerdaderoFalsoClasico(String pregunta,Respuesta respuesta) {
        enunciado = pregunta;
        respuestaCorrecta = respuesta;
    }

    @Override
    private Respuesta obtenerRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public boolean EsLaRespuestaCorrecta(Respuesta respuestaDelJugador) {
        return respuestaCorrecta.esCorrecta(respuestaDelJugador);
    }
}
