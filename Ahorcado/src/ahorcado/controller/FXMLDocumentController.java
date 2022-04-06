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
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
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
     GraphicsContext cabeza;
     GraphicsContext cuerpo;
     GraphicsContext brazoIzquierdo;
     GraphicsContext brazoDerecho;
     GraphicsContext piernaIzquierda;
     GraphicsContext piernaDerecha;
     
    @FXML
    private Label labelPalabraSecreta;
    @FXML
    private ListView<Character> listViewCaracteresIntroducidos;//introducir char??
    @FXML
    private ListView<String> listViewPalabrasIntentadas;
    @FXML
    private Canvas canvasAhorcado;
    
    Alert Perder;
    Alert Ganar;
    Ahorcado partida ; 
    @FXML
    private Label labelIntroduce;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partida = new Ahorcado();
        labelPalabraSecreta.setText(partida.compararOcultarPalabra());
        Perder = new Alert(Alert.AlertType.INFORMATION ,"Perdiste la palabra secreta era"+ partida.getPalabraSecreta());
        Ganar = new Alert(Alert.AlertType.INFORMATION ,"Ganaste!!");
        
        gc = canvasAhorcado.getGraphicsContext2D();
        cabeza = canvasAhorcado.getGraphicsContext2D();
        cuerpo = canvasAhorcado.getGraphicsContext2D();
        brazoIzquierdo = canvasAhorcado.getGraphicsContext2D();
        brazoDerecho = canvasAhorcado.getGraphicsContext2D();
        piernaIzquierda = canvasAhorcado.getGraphicsContext2D();
        piernaDerecha = canvasAhorcado.getGraphicsContext2D();
        
        
        canvasAhorcado.setFocusTraversable(true); 
        
        
        
        generarAhorcado();
    }
    /**
     * Metodo que genera la escena inicial del ahorcado
     */
    public void generarAhorcado(){
        
        gc.setFill(Color.BLACK);
        gc.fillRect(20, 172, 20, 200); //coordenadas (X, Y, ancho, largo)
        gc.fillRect(10, 362, 40,10);
        gc.fillRect(20,172, 100, 20);
        gc.fillRect(100, 172, 5, 40);
        
    }    
    
    public void generarCabeza(){
        cabeza.fillRoundRect(92, 212, 20, 20, 20, 20);
    }
    
    public void generarCuerpo(){
        cuerpo.fillOval(92, 232, 20, 40);
    }
    
    public void generarBrazoIzquierdo(){
        brazoIzquierdo.fillRect(90, 240, 5, 20); //segunda parte en generarse
    }
    
    public void generarBrazoDerecho(){
        brazoDerecho.setFill(Color.AQUA);
        brazoDerecho.fillRect(110, 240, 5, 20); //primera parte en generarse tras el cuerpo
    }
    
    public void generarPiernaIzquierda(){ 
        piernaIzquierda.fillRect(90, 265, 5, 20); //cuarta parte en generarse
    }
    
    public void generarPiernaDerecha(){
       piernaDerecha.fillRect(110, 265, 5, 20); //tercera parte en generarse
    }
    public void terminarPartidaPerdida(){
            Perder.showAndWait();
            limpiar();
            
    }
    public void terminarPartidaGanar(){
        Ganar.showAndWait();
        limpiar();
    }
    public void limpiar(){
            textFieldCaracteresAdivinar.disableProperty();
            textFieldPalabraResolver.disableProperty();
            listViewCaracteresIntroducidos.disableProperty();
            listViewPalabrasIntentadas.disableProperty();
            textFieldCaracteresAdivinar.setOpacity(0);
            textFieldPalabraResolver.setOpacity(0);
            listViewCaracteresIntroducidos.setOpacity(0);
            listViewPalabrasIntentadas.setOpacity(0);
            canvasAhorcado.setOpacity(0);
            
            
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
            generarBrazoDerecho();
        }
        if(partida.getNumErrores()==4){
            generarBrazoIzquierdo();
        }
        if(partida.getNumErrores()==5){
            generarPiernaDerecha();
        }
        if(partida.getNumErrores()==6){
            generarPiernaIzquierda();
            
            terminarPartidaPerdida();
            
        }
        if(partida.compararOcultarPalabra()==partida.getPalabraSecreta()){
            terminarPartidaGanar();
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
         partida.aumentarErrorPalabra(palabraIntroducida);  
        if(partida.getNumErrores()==1){
            generarCabeza();
        }
        if(partida.getNumErrores()==2){
            generarCuerpo();
        }
        if(partida.getNumErrores()==3){
            generarBrazoDerecho();
        }
        if(partida.getNumErrores()==4){
            generarBrazoIzquierdo();
        }
        if(partida.getNumErrores()==5){
            generarPiernaDerecha();
        }
        if(partida.getNumErrores()==6){
            generarPiernaIzquierda();
            
            terminarPartidaPerdida();

        }
        if(partida.compararOcultarPalabra()==partida.getPalabraSecreta()){
            terminarPartidaGanar();
        }

        labelPalabraSecreta.setText(partida.compararOcultarPalabra()); 
         
         
         
         textFieldPalabraResolver.clear();
    }
    
}
