/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Oscar
 */
public class VistaActvidadesController implements Initializable {

    @FXML
    private Label lblPregunta;
    @FXML
    private RadioButton rbcOpc1;
    @FXML
    private RadioButton rbcOpc2;
    @FXML
    private RadioButton rbcOpc3;
    @FXML
    private RadioButton rbcOpc4;
    @FXML
    private Label lblAlias;
    @FXML
    private Label lblTiempo;
    @FXML
    private Label lblPunteo;
    @FXML
    private Button btnSiguiente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lblAlias.setText(VistaEvaluacionController.alias);
        ToggleGroup tg = new ToggleGroup();
        this.rbcOpc1.setToggleGroup(tg);
        this.rbcOpc2.setToggleGroup(tg);
        this.rbcOpc3.setToggleGroup(tg);
        this.rbcOpc4.setToggleGroup(tg);
    }

    @FXML
    private void siguiente(ActionEvent event) {
    }

}
