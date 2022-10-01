/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import static controlador.VistaCrearCuestionarioController.descripcion;
import static controlador.VistaCrearCuestionarioController.titulo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cuestionario;

/**
 * FXML Controller class
 *
 * @author Oscar
 */
public class VistaDetalleCuestionarioController implements Initializable {

    @FXML
    private TableView<Cuestionario> tblPreguntasCuestionario;
    @FXML
    private TableColumn colPregunta;
    @FXML
    private TableColumn colTiempo;
    @FXML
    private TableColumn colPunteo;
    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblDescripcion;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnNuevaPregunta;

    private ObservableList<Cuestionario> personas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        personas = FXCollections.observableArrayList();
        this.tblPreguntasCuestionario.setItems(personas);

        this.colPregunta.setCellValueFactory(new PropertyValueFactory("Pregunta"));
        this.colTiempo.setCellValueFactory(new PropertyValueFactory("Tiempo"));
        this.colPunteo.setCellValueFactory(new PropertyValueFactory("Punteo"));

        this.lblTitulo.setText(VistaCrearCuestionarioController.titulo);
        this.lblDescripcion.setText(VistaCrearCuestionarioController.descripcion);        
    }

    @FXML
    private void modificarPregunta(ActionEvent event) {
        Cuestionario p = this.tblPreguntasCuestionario.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR!");
            alert.setContentText("Selecciona primero una pregunta!");
            alert.showAndWait();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaCrearPregunta.fxml"));

                Parent root = loader.load();

                VistaCrearPreguntaController controlador = loader.getController();
                controlador.initAttributtes(personas, p);

                Scene scene = new Scene(root);

                Stage stage = new Stage();

                stage.initModality(Modality.APPLICATION_MODAL);

                stage.setScene(scene);

                stage.showAndWait();

                Cuestionario aux = controlador.getPersona();
                if (aux != null) {
                    this.tblPreguntasCuestionario.refresh();
                }

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error!");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void borrarPregunta(ActionEvent event) {
        Cuestionario p = this.tblPreguntasCuestionario.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR!");
            alert.setContentText("Selecciona primero una pregunta!");
            alert.showAndWait();
        } else {
            this.personas.remove(p);
            this.tblPreguntasCuestionario.refresh();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion!");
            alert.setContentText("Se ha borrado la pregunta!");
            alert.showAndWait();
        }
    }

    @FXML
    private void agregarPregunta(ActionEvent event) {
        this.lblTitulo.setText(VistaCrearCuestionarioController.titulo);
        this.lblDescripcion.setText(VistaCrearCuestionarioController.descripcion);
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaCrearPregunta.fxml"));

            Parent root = loader.load();

            VistaCrearPreguntaController controlador = loader.getController();
            controlador.initAttributtes(personas);

            Scene scene = new Scene(root);

            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setScene(scene);

            stage.showAndWait();

            Cuestionario p = controlador.getPersona();
            if (p != null) {
                this.personas.add(p);
                this.tblPreguntasCuestionario.refresh();
            }

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        
    }

}
