/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import modelo.Cuestionario;

/**
 * FXML Controller class
 *
 * @author Oscar
 */
public class VistaCrearPreguntaController implements Initializable {

    @FXML
    private TextField txtPregunta;
    @FXML
    private TextField txtPuntos;
    @FXML
    private ChoiceBox<Integer> myChoiceBoxTiempos;
    @FXML
    private RadioButton rdbOpcion1;
    @FXML
    private RadioButton rdbOpcion2;
    @FXML
    private RadioButton rdbOpcion3;
    @FXML
    private RadioButton rdbOpcion4;
    @FXML
    private TextField txtOpc1;
    @FXML
    private TextField txtOpc2;
    @FXML
    private TextField txtOpc3;
    @FXML
    private TextField txtOpc4;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;

    private Integer[] tiempos = {5, 10, 15, 20};

    private Cuestionario persona;

    private ObservableList<Cuestionario> personas;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myChoiceBoxTiempos.getItems().addAll(tiempos);

        ToggleGroup tg = new ToggleGroup();
        this.rdbOpcion1.setToggleGroup(tg);
        this.rdbOpcion2.setToggleGroup(tg);
        this.rdbOpcion3.setToggleGroup(tg);
        this.rdbOpcion4.setToggleGroup(tg);
    }

    public void initAttributtes(ObservableList<Cuestionario> personas) {
        this.personas = personas;
    }
    
    
    public void initAttributtes(ObservableList<Cuestionario> personas, Cuestionario p) {
        this.personas = personas;
        this.persona = p;
        
       
        
        this.txtPregunta.setText(p.getPregunta());
        this.txtPuntos.setText(p.getPunteo() + "");
        this.txtOpc1.setText(p.getRespuesta1());
        this.txtOpc2.setText(p.getRespuesta2());
        this.txtOpc3.setText(p.getRespuesta3());
        this.txtOpc4.setText(p.getRespuesta4());
        this.myChoiceBoxTiempos.setValue(p.getTiempo());

    }

    @FXML
    private void guardarPregunta(ActionEvent event) {
        String titulo = VistaCrearCuestionarioController.titulo;
        String descripcion = VistaCrearCuestionarioController.descripcion;
        String estado = "REGISTRADO";
        
        String pregunta = this.txtPregunta.getText();

        int tiempo = myChoiceBoxTiempos.getValue();

        int punteo = Integer.parseInt(this.txtPuntos.getText());

        String respuesta1 = this.txtOpc1.getText();
        String respuesta2 = this.txtOpc2.getText();
        String respuesta3 = this.txtOpc3.getText();
        String respuesta4 = this.txtOpc4.getText();

        String respuestaCorrecta = "";

        if (rdbOpcion1.isSelected()) {
            respuestaCorrecta = this.txtOpc1.getText();
        } else if (rdbOpcion2.isSelected()) {
            respuestaCorrecta = this.txtOpc2.getText();
        } else if (rdbOpcion3.isSelected()) {
            respuestaCorrecta = this.txtOpc3.getText();
        } else if (rdbOpcion4.isSelected()) {
            respuestaCorrecta = this.txtOpc4.getText();
        }

        Cuestionario p= new Cuestionario(titulo, descripcion, estado, pregunta, tiempo, punteo, respuesta1, respuesta2, respuesta3, respuesta4, respuestaCorrecta);
        //Cuestionario p = new Cuestionario(pregunta, tiempo, punteo, respuesta1, respuesta2, respuesta3, respuesta4, respuestaCorrecta);
        
       
        if (!personas.contains(p)) {

            //Modificamos 
            if (this.persona != null) {
                this.persona.setPregunta(pregunta);

                this.persona.setPunteo(punteo);

                this.persona.setTiempo(tiempo);

                this.persona.setRespuesta1(respuesta1);
                this.persona.setRespuesta2(respuesta2);
                this.persona.setRespuesta3(respuesta3);
                this.persona.setRespuesta4(respuesta4);

                this.persona.setRespuestaCorrecta(respuestaCorrecta);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion!");
                alert.setContentText("Se ha modificado correctamente la pregunta!");
                alert.showAndWait();
                
            } //Insertando
            else {
                this.persona = p;
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion!");
                alert.setContentText("Se ha agregado correctamente! ");
                alert.showAndWait();
                
              
            }

            Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("La pregunta ya existe!");
            alert.showAndWait();
        }
   

    }

    @FXML
    private void salir(ActionEvent event) {
        this.persona = null;
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }

    public Cuestionario getPersona() {
        return this.persona;
    }

}
