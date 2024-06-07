package main.exceptions;

public class AnuladorSeUsaMasDeUnaVez extends Throwable {
    public AnuladorSeUsaMasDeUnaVez(String mensaje) {
        super(mensaje);
    }
}
