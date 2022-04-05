/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.controller;


import ahorcado.model.Ahorcado;
import com.sun.deploy.config.JREInfo;
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
    private TextField textFieldCaracteresAdivinar;
    @FXML
    private TextField textFieldPalabraResolver;
    @FXML
    private Label labelCaractertesAdivinar;
    @FXML
    private Label labelPalabrasAdivinar;
    private Canvas visualAhorcado;

     GraphicsContext gc;
    @FXML
    private Label labelPalabraSecreta;
    @FXML
    private ListView<Character> listViewCaracteresIntroducidos;//introducir char??
    @FXML
    private ListView<String> listViewPalabrasIntentadas;
    @FXML
    private Canvas canvasAhorcado;
    
    
    Ahorcado partida ; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partida = new Ahorcado();
        labelPalabraSecreta.setText(partida.compararOcultarPalabra());
        gc = canvasAhorcado.getGraphicsContext2D();
        
        canvasAhorcado.setFocusTraversable(true); 
        
        
        
        generarAhorcado();
    }
    /**
     * Metodo que genera la escena inicial del ahorcado
     */
    public void generarAhorcado(){
        
        gc.setFill(Color.BLACK);
        gc.fillRect(20, 272, 20, 100); //coordenadas (X, Y, ancho, largo)
        gc.setFill(Color.BLACK);
        gc.fillRect(10, 362, 40,10);
        
    }    
    
    public void generarCabeza(){
    
    }
    
    public void generarCuerpo(){
    
    }
    
    public void generarBrazoIzquierdo(){
    
    }
    
    public void generarBrazoDerecho(){
    
    }
    
    public void generarPiernaIzquierda(){
    
    }
    
    public void generarPiernaDerecha(){
    
    }
    
    /**
     * Metodo que guarda el texto introducido en su lista correspondiente
     * @param event 
     */
    @FXML
    private void ejecutarEnterCaracter(ActionEvent event) {
        listViewCaracteresIntroducidos.getItems().add(textFieldCaracteresAdivinar.getText().charAt(0)); //solo recoge el primer caracter de un string
        String Caracter = "a";
        String letraIntroducida=textFieldCaracteresAdivinar.getText();
        if (Caracter.length() == letraIntroducida.length()){
        partida.aumentarErrorLetra(letraIntroducida);  
        if(partida.getNumErrores()==1){
            generarCabeza();
        }
        if(partida.getNumErrores()==2){
            generarCuerpo();
        }
        if(partida.getNumErrores()==3){
            generarCuerpo();
        }
        if(partida.getNumErrores()==4){
            generarBrazoDerecho();
        }
        if(partida.getNumErrores()==5){
            generarBrazoIzquierdo();
        }
        if(partida.getNumErrores()==6){
            generarPiernaDerecha();
        }
        if(partida.getNumErrores()==7){
            generarPiernaIzquierda();
        }
        }
       labelPalabraSecreta.setText(partida.compararOcultarPalabra());
        
        
        textFieldCaracteresAdivinar.clear();
    }
    /**
     * Metodo que guarda el texto introducido en su lista correspondiente
     * @param event 
     */
    @FXML
    private void ejecutarEnterPalabra(ActionEvent event) {
         listViewPalabrasIntentadas.getItems().add(textFieldPalabraResolver.getText());
          String palabraIntroducida=textFieldPalabraResolver.getText();
         partida.aumentarErrorLetra(palabraIntroducida);  
        if(partida.getNumErrores()==1){
            generarCabeza();
        }
        if(partida.getNumErrores()==2){
            generarCuerpo();
        }
        if(partida.getNumErrores()==3){
            generarCuerpo();
        }
        if(partida.getNumErrores()==4){
            generarBrazoDerecho();
        }
        if(partida.getNumErrores()==5){
            generarBrazoIzquierdo();
        }
        if(partida.getNumErrores()==6){
            generarPiernaDerecha();
        }
        if(partida.getNumErrores()==7){
            generarPiernaIzquierda();
        }
        labelPalabraSecreta.setText(partida.compararOcultarPalabra()); 
         
         
         
         textFieldPalabraResolver.clear();
    }
    
}
