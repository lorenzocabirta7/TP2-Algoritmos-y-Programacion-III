package edu.fiuba.algo3.Alertas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BonificadorSeUsoMasVecesDeLoEsperado {
    public static void mostrarAlerta() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("El bonificador se ha usado más veces de lo permitido.");
        alert.showAndWait();
    }
}
