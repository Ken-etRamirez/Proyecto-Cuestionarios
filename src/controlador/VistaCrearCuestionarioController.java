/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cuestionario;

/**
 * FXML Controller class
 *
 * @author Oscar
 */
public class VistaCrearCuestionarioController implements Initializable {

    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAgregar;

    public static String titulo;
    public static String descripcion;

    private Cuestionario persona;
    private ObservableList<Cuestionario> personas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void arrancarAtributos(ObservableList<Cuestionario> personas) {
        this.personas = personas;
    }

    @FXML
    private void cancelar(ActionEvent event) {
        this.persona = null;
        Stage stag = (Stage) this.btnAgregar.getScene().getWindow();
        stag.close();
    }

    @FXML
    private void agregarCuestionario(ActionEvent event) {
        try {
            titulo = this.txtTitulo.getText();
            descripcion = this.txtDescripcion.getText();
            String estado = "REGISTRADO";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaDetalleCuestionario.fxml"));

            Parent root = loader.load();

            VistaDetalleCuestionarioController controlador = loader.getController();

            Scene scene = new Scene(root);

            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setScene(scene);

            stage.showAndWait();

            Cuestionario p = new Cuestionario(titulo, descripcion, estado);

            if (!personas.contains(p)) {
                this.persona = p;
                Stage stag = (Stage) this.btnAgregar.getScene().getWindow();
                stag.close();
            } else {
    
            }

        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cuestionario getPersona() {
        return persona;
    }

}
