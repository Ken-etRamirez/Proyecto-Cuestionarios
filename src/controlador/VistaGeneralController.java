/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
public class VistaGeneralController implements Initializable {

    @FXML
    private TableView<Cuestionario> tblCuestionarios;
    @FXML
    private TableColumn colPin;
    @FXML
    private TableColumn colTitulo;
    @FXML
    private TableColumn colDescripcion;
    @FXML
    private TableColumn colEstado;
    @FXML
    private Button btnAgregar;

    private ObservableList<Cuestionario> personas;

    @FXML
    private Button btnActivar;
    @FXML
    private Button btnClonar;
    @FXML
    private Button btnEvaluar;
    @FXML
    private Button btnTop3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        personas = FXCollections.observableArrayList();

        this.colPin.setCellValueFactory(new PropertyValueFactory("PIN"));
        this.colTitulo.setCellValueFactory(new PropertyValueFactory("Titulo"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
        this.colEstado.setCellValueFactory(new PropertyValueFactory("Estado"));
        this.tblCuestionarios.setItems(personas);
    }

    @FXML
    private void nuevoCuestionario(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaCrearCuestionario.fxml"));

            Parent root = loader.load();

            VistaCrearCuestionarioController controlador = loader.getController();
            controlador.arrancarAtributos(personas);

            Scene scene = new Scene(root);

            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setScene(scene);

            stage.showAndWait();

            Cuestionario p = controlador.getPersona();
            if (p != null) {
                this.personas.add(p);
                this.tblCuestionarios.refresh();
            }
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void activarCuestionario(ActionEvent event) {
        Cuestionario p = this.tblCuestionarios.getSelectionModel().getSelectedItem();

        p.setEstado("ACTIVADO");
        Random r = new Random();
        int cantidad = r.nextInt(900000) + 100000;
        p.setPIN(cantidad);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion!");
        alert.setContentText("Se ha activado correctamente!");
        alert.showAndWait();
        this.tblCuestionarios.refresh();

    }

    @FXML
    private void clonarCuestionario(ActionEvent event) {
        Cuestionario p = this.tblCuestionarios.getSelectionModel().getSelectedItem();
        p.setEstado("COPIA");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion!");
        alert.setContentText("Se ha clonado correctamente!");
        alert.showAndWait();
        personas.add(p);
        this.tblCuestionarios.refresh();
    }

    @FXML
    private void evaluar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaEvaluacion.fxml"));

            Parent root = loader.load();

            VistaEvaluacionController controlador = loader.getController();

            Scene scene = new Scene(root);

            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setScene(scene);

            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void verTop3(ActionEvent event) {
        try {
            Document document = new Document();

            String ruta = "C:\\Users\\Oscar\\Desktop\\ProyectoCuestionariosFX\\PDF\\reporte.pdf";

            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            Phrase p = new Phrase("Generando Reporte...");
            document.add(p);

            document.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion!");
            alert.setContentText("Se ha creado el PDF!");
            alert.showAndWait();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
