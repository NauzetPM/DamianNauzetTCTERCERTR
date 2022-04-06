/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.controller;

import ahorcado.model.Ahorcado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author JDamian
 * @author Nauzet
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
    @FXML
    private Label labelPalabraSecreta;
    @FXML
    private ListView<Character> listViewCaracteresIntroducidos;//introducir char??
    @FXML
    private ListView<String> listViewPalabrasIntentadas;
    @FXML
    private Canvas canvasAhorcado;
    @FXML
    private Label labelIntroduce;

    private Canvas visualAhorcado;
    
    Alert Perder;
    Alert Ganar;
    Ahorcado partida;

    GraphicsContext gc;
    GraphicsContext cabeza;
    GraphicsContext cuerpo;
    GraphicsContext brazoIzquierdo;
    GraphicsContext brazoDerecho;
    GraphicsContext piernaIzquierda;
    GraphicsContext piernaDerecha;
    @FXML
    private Button buttonReiniciar;
    @FXML
    private Label labelTituloPalabraSecreta;

    /**
     * Metodo que inicializa el juego
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        limpiar();
    }
    
    public void iniciar(){
        partida = new Ahorcado();
        labelPalabraSecreta.setText(partida.compararOcultarPalabra());
        Perder = new Alert(Alert.AlertType.INFORMATION, "Perdiste la palabra secreta era " + partida.getPalabraSecreta());
        Ganar = new Alert(Alert.AlertType.INFORMATION, "Ganaste!!");

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
    public void generarAhorcado() {

        gc.setFill(Color.BLACK);
        gc.fillRect(20, 172, 20, 200); //coordenadas (X, Y, ancho, largo)
        gc.fillRect(10, 362, 40, 10);
        gc.fillRect(20, 172, 100, 20);
        gc.fillRect(100, 172, 5, 40);

    }

    /**
     * Metodo que genera la cabeza al fallar
     */
    public void generarCabeza() {
        cabeza.fillRoundRect(92, 212, 20, 20, 20, 20);
    }

    /**
     * Metodo que genera el cuerpo al fallar
     */
    public void generarCuerpo() {
        cuerpo.fillOval(92, 232, 20, 40);
    }

    /**
     * Metodo que genera el brazo izquierdo al fallar
     */
    public void generarBrazoIzquierdo() {
        brazoIzquierdo.fillRect(90, 240, 5, 20); //segunda parte en generarse
    }

    /**
     * Metodo que genera el brazo derecho al fallar
     */
    public void generarBrazoDerecho() {
        brazoDerecho.setFill(Color.AQUA);
        brazoDerecho.fillRect(110, 240, 5, 20); //primera parte en generarse tras el cuerpo
    }

    /**
     * Metodo que genera la pierna izquierda al fallar
     */
    public void generarPiernaIzquierda() {
        piernaIzquierda.fillRect(90, 265, 5, 20); //cuarta parte en generarse
    }

    /**
     * Metodo que genera la pierna derecha al fallar
     */
    public void generarPiernaDerecha() {
        piernaDerecha.fillRect(110, 265, 5, 20); //tercera parte en generarse
    }

    /**
     * Metodo que termina la partida al perder y mustra una ventana de "derrota"
     */
    public void terminarPartidaPerdida() {
        Perder.showAndWait();
        limpiar();
    }

    /**
     * Metodo que termina la partida al ganar y muestra una pantalla de
     * "victoria"
     */
    public void terminarPartidaGanar() {
        Ganar.showAndWait();
        limpiar();
    }

    /**
     * Metodo que limpia la pantalla al finalizar la partida e inicia una nueva
     */
    public void limpiar() { //deberia estar en el modelo supuestamente
        textFieldCaracteresAdivinar.clear();
        textFieldPalabraResolver.clear();
        listViewCaracteresIntroducidos.getItems().clear();
        listViewPalabrasIntentadas.getItems().clear();
        canvasAhorcado.getGraphicsContext2D().clearRect(39, 90, 322, 372);
        
        iniciar();

    }

    /**
     * Metodo que guarda el texto introducido en su lista correspondiente
     *
     * @param event Se activa al pulsar la tecla "enter"
     */
    @FXML
    private void ejecutarEnterCaracter(ActionEvent event) {
        listViewCaracteresIntroducidos.getItems().add(textFieldCaracteresAdivinar.getText().charAt(0)); //solo recoge el primer caracter de un string
        String Caracter = "a";
        String letraIntroducida = textFieldCaracteresAdivinar.getText().toLowerCase();
        if (Caracter.length() == letraIntroducida.length()) {
            partida.aumentarErrorLetra(letraIntroducida);
            if (partida.getNumErrores() == 1) {
                generarCabeza();
            }
            if (partida.getNumErrores() == 2) {
                generarCuerpo();
            }
            if (partida.getNumErrores() == 3) {
                generarBrazoDerecho();
            }
            if (partida.getNumErrores() == 4) {
                generarBrazoIzquierdo();
            }
            if (partida.getNumErrores() == 5) {
                generarPiernaDerecha();
            }
            if (partida.getNumErrores() == 6) {
                generarPiernaIzquierda();

                terminarPartidaPerdida();

            }
            if (partida.compararOcultarPalabra() == partida.getPalabraSecreta()) {
                terminarPartidaGanar();
            }
        }
        labelPalabraSecreta.setText(partida.compararOcultarPalabra());

        textFieldCaracteresAdivinar.clear();
    }

    /**
     * Metodo que guarda el texto introducido en su lista correspondiente
     *
     * @param event
     */
    @FXML
    private void ejecutarEnterPalabra(ActionEvent event) {
        listViewPalabrasIntentadas.getItems().add(textFieldPalabraResolver.getText().toLowerCase());
        String palabraIntroducida = textFieldPalabraResolver.getText().toLowerCase();
        partida.aumentarErrorPalabra(palabraIntroducida);
        if (partida.getNumErrores() == 1) {
            generarCabeza();
        }
        if (partida.getNumErrores() == 2) {
            generarCuerpo();
        }
        if (partida.getNumErrores() == 3) {
            generarBrazoDerecho();
        }
        if (partida.getNumErrores() == 4) {
            generarBrazoIzquierdo();
        }
        if (partida.getNumErrores() == 5) {
            generarPiernaDerecha();
        }
        if (partida.getNumErrores() == 6) {
            generarPiernaIzquierda();

            terminarPartidaPerdida();

        }
        if (partida.compararOcultarPalabra() == partida.getPalabraSecreta()) {
            terminarPartidaGanar();
        }

        labelPalabraSecreta.setText(partida.compararOcultarPalabra());

        textFieldPalabraResolver.clear();
    }
    /**
     * Boton que al pulsarlo reinicia el juego
     * @param event pulsar el boton
     */
    @FXML
    private void reinicio(ActionEvent event) {
        limpiar();

    }

}
