package main.Respuestas;

public class SinOrden implements TipoDeOrden{

    @Override
    public int actualizarPuntaje(int puntaje, Respuesta unaRespuesta){
        return puntaje;
    }

    @Override
    public String getOrdenParcial(){
        return "0";
    } //No tener orden lo definimos asi

}
