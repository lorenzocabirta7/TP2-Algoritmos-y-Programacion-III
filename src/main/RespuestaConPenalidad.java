package main;

public class RespuestaConPenalidad implements TipoDeRespuesta{
    @Override
    public int actualizarPuntaje(int puntaje){
        return (puntaje * -1);
    };
}
