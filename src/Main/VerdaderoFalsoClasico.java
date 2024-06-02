package main;


//Asigna un punto a cada jugador que responda con la opción correcta
public class VerdaderoFalsoClasico implements Pregunta {

    private String enunciado;

    private Respuesta respuestaCorrecta;



    public VerdaderoFalsoClasico(String pregunta,Respuesta respuesta) {
        enunciado = pregunta;
        respuestaCorrecta = respuesta;

    }

    @Override
    public void puntuar(Respuesta respuesta) {
        if (respuesta.esCorrecta()){
            respuesta.actualizar_puntaje(1);
        }else {
            respuesta.actualizar_puntaje(0);
        }
    }


}
