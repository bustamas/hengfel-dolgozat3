/*
* File: MainController.java
* Author: Bús Tamás
* Copyright: 2025 Bús Tamás
* Group: Szoft  1/N
* Date: 2025-05-27
* Github: https://github.com/bustamas
* Licenc: MIT
*/
package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class MainController {

    @FXML
    private TextField rField;

    @FXML
    private TextField hField;

    @FXML
    private Label resultLabel;

    @FXML
    private Label dateLabel;

    @FXML
    public void initialize() {
        dateLabel.setText("Dátum: " + LocalDate.now());
    }

    @FXML
    private void handleCalc() {
        try {
            double r = Double.parseDouble(rField.getText());
            double h = Double.parseDouble(hField.getText());
            double area = 2 * Math.PI * r * (r + h);

            resultLabel.setText(String.format("Felszín: %.2f", area));

            FileWriter fw = new FileWriter("eredmenyek.txt", true);
            fw.write("r=" + r + ", h=" + h + ", felszín=" + area + "\n");
            fw.close();

        } catch (NumberFormatException e) {
            resultLabel.setText("Hibás számformátum!");
        } catch (IOException e) {
            resultLabel.setText("Fájlhiba történt!");
        }
    }
}