package main;

import java.util.ArrayList;

public class RespuestaVerdaderoFalsoStrategy extends FormasDeResponder {

    public RespuestaVerdaderoFalsoStrategy(FormaRespuesta unaFormaDeResponder)
    {
        super(unaFormaDeResponder);
    }
    public ArrayList<Respuesta> responder(PreguntaVerdaderoFalsoClasico pregunta)
    {
        return super.responder(pregunta);
    }
}
