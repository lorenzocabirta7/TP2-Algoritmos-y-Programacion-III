package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Puntaje {
    private ArrayList<Integer> puntos = new ArrayList<>();
    public Puntaje(){
    }

    public void agregarPuntaje(int puntos){
        this.puntos.add(puntos);
    }

    public int getPuntaje(){
        int puntajeTotal = 0;
        for (Integer punto : puntos){
            puntajeTotal += punto;
        }
        return puntajeTotal;
        //return puntos.stream().mapToInt(i -> i).sum();
    }

    public void anularUltimoPuntaje(){
        puntos.set(puntos.size() - 1, 0);
    }

    public void multiplicarUltimoPuntaje(int unMultiplicador){
        puntos.set(puntos.size() -1, puntos.get(puntos.size() - 1) * unMultiplicador);
    }

}
