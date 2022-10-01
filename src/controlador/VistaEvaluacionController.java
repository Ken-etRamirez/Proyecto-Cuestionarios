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
public class VistaEvaluacionController implements Initializable {

    @FXML
    private TextField txtPIN;
    @FXML
    private TextField txtAlias;
    @FXML
    private Button btnIngresar;
    public static String alias;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ingresar(ActionEvent event) {
       long pin=Long.parseLong(txtPIN.getText());
       
       alias= this.txtAlias.getText();
       try {   
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaActvidades.fxml"));

            Parent root = loader.load();

            VistaActvidadesController controlador = loader.getController();

            Scene scene = new Scene(root);

            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setScene(scene);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion!");
            alert.setContentText("Ingreso Correcto!");
            alert.showAndWait();
            
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
