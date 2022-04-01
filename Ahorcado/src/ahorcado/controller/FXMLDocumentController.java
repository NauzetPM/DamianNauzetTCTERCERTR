/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author daw
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Label labelTitulo;
    @FXML
    private TextField textFieldPalabraSecreta;
    @FXML
    private TextField textFieldCaracteresAdivinar;
    @FXML
    private TextField textFieldPalabraResolver;
    @FXML
    private Label labelCaractertesAdivinar;
    @FXML
    private Label labelPalabrasAdivinar;
    @FXML
    private ListView<?> textAreaCaracteresIntroducidos;
    @FXML
    private Pane visualAhorcado;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
