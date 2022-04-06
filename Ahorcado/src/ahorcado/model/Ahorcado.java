/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.model;

import java.util.ArrayList;

/**
 *
 * @author Nauzet
 * @author JDamian
 */
/**
 * Método base del juego
 *
 * @author JDamian
 * @author Nauzet
 */
public class Ahorcado {

    public String palabraSecreta;
    public int errores;
    public boolean victoria;
    private ArrayList<String> historialLetras;
    public final String[] palabras = {
        "prueba", "gato", "murcie"
        + "lago", "caballero", "esternocleidomastoideo", "perro", "frances", 
        "canario", "telefono", "ordenador", "compilar", "televisor"
    };//poner palabras en el String

    /**
     * Constructor base
     */
    public Ahorcado() {
        this.errores = 0;
        this.victoria = false;
        generarPalabraSecreta();
        historialLetras = new ArrayList<>();
    }

    /**
     * Metodo que suma 1 a los errores al introducir un caracter
     *
     * @param letra
     */
    public void aumentarErrorLetra(String letra) {
        addLetra(letra);
        if (!palabraSecreta.contains(letra)) {
            this.errores += 1;
        } else {
            compararOcultarPalabra();
        }
    }

    /**
     * Método que suma 1 a los errores al introducir una palabra completa
     *
     * @param palabra
     */
    public void aumentarErrorPalabra(String palabra) {
        if (!palabraSecreta.equals(palabra)) {
            this.errores += 1;
        } else {
            addLetra(palabra);
            compararOcultarPalabra();
        }
    }

    /**
     * Metodo que agrega cadenas de texto
     *
     * @param letra devueve letras
     */
    public void addLetra(String letra) {
        historialLetras.add(letra);
    }

    /**
     * Metodo que dependiendo de la palabra secreta genera los guiones necesario
     * y genera un array de String en el que esta la palabra secreta separada en
     * caracteres
     *
     * @return devuelve guiones por cada char de la palabra a adivinar
     */
    public String compararOcultarPalabra() {
        String palabra = this.palabraSecreta;
        String letraselegidas = "";
        for (int i = 0; i < historialLetras.size(); i++) {
            letraselegidas += historialLetras.get(i);
        }
        String palabraconguiones = palabra.replaceAll("[^ " + letraselegidas + "]", "_ ");

        return palabraconguiones;
    }

    /**
     * Metodo que elige una palabra aleatoriamente del String
     */
    public void generarPalabraSecreta() {
        this.palabraSecreta = this.palabras[(int) ((Math.random() * this.palabras.length))];
    }

    //GETTERS Y SETTERS
    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public String getHistorialLetras() {
        String letrasStr = "";

        for (String Letra : historialLetras) {
            letrasStr += Letra;
        }
        String historialStr = "";

        if (letrasStr.length() > 0) {
            for (int i = 0; i < letrasStr.length(); i++) {
                historialStr += letrasStr.charAt(i) + ",";
            }
        }

        return historialStr;
    }

    /**
     * Metodo que devuelve el numero de errores
     *
     * @return devuelve errores
     */
    public Integer getNumErrores() {
        return errores;
    }

    /**
     * Metodo que anota los fallos
     *
     * @param errores devuelve los errores
     */
    public void setFallos(Integer errores) {
        this.errores = errores;
    }

}
