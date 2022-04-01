/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.controller;


import static java.lang.System.gc;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;





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
    private Canvas visualAhorcado;

     GraphicsContext gc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         gc = visualAhorcado.getGraphicsContext2D();
        
        visualAhorcado.setFocusTraversable(true); 

        generarAhorcado();
    }
    
    public void generarAhorcado(){
        
        gc.setFill(Color.BLACK);
        gc.fillRect(20, 20, 20, 100);
        gc.setFill(Color.BLACK);
        gc.fillRect(10, 120, 40,10);
        
    }    
    
}
