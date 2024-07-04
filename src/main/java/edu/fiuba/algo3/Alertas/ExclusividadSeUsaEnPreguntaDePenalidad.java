package edu.fiuba.algo3.Alertas;

import javafx.scene.control.Alert;

public class ExclusividadSeUsaEnPreguntaDePenalidad {
    public static void mostrarAlerta() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("La exclusividad solo se puede usar en preguntas sin penalidad.");
        alert.showAndWait();
    }
}
