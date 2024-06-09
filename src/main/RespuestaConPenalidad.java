package main;

public class RespuestaConPenalidad implements TipoDeRespuesta{
    @Override
    public int actualizarPuntaje(int puntaje){
        if (puntaje == 0){
            return -1;
        } else
            return -1*puntaje;
    };
}
