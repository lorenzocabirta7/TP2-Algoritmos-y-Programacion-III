package main;

import java.util.ArrayList;

public class RespuestaVerdaderoFalsoStrategy extends formasDeResponder {

    public RespuestaVerdaderoFalsoStrategy(FormaRespuesta unaFormaDeResponder)
    {
        super(unaFormaDeResponder);
    }
    public ArrayList<Respuesta> responder(Pregunta pregunta)
    {
        return super.responder(pregunta);
    }
}
