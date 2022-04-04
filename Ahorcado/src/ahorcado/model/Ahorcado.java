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
 */
public class Ahorcado {
    public String palabraSecreta;
    public int errores;
    public boolean victoria;
    public String palabraAadivinarConGuiones;
    public String[] ArrayPalabraAadivinar;
    private ArrayList<String> historialLetras; 
    public final String[] palabras={
       
    };//poner palabras en el String
    
    /**
     * Construtor por defecto
     */
    public Ahorcado(){
        
    }
    /**
     * Metodo que suma 1 a los errores
     */
    public void AumentarError() {

        this.errores += 1;

    }


    public void addLetra(String letra) {

        historialLetras.add(letra);

    }
      /**
       * Metodo que dependiendo de la palabra secreta genera los guiones 
       * necesario y genera un array de String en el que esta la palabra secreta 
       * separada en caracteres
       */
       public void ocultarPalabra () {
        String palabra = this.palabraSecreta;
        String letraselegidas = "";
        for (int i = 0; i < historialLetras.size(); i++) {
            letraselegidas += historialLetras.get(i);
    }
       }



       /**
        * Metodo que elige una palabra aleatoriamente del String
        */
       public void GenerarPalabraSecreta(){
            this.palabraSecreta=this.palabras[(int) ((Math.random() * this.palabras.length)+1)];
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
        
        if(letrasStr.length()>0){
            for (int i = 0; i < letrasStr.length(); i++) {
                historialStr += letrasStr.charAt(i) + ",";
            }
        }
        
        
        return historialStr;
    }
    public Integer getNumErrores() {
    return errores;
    }

    public void setFallos(Integer errores) {
        this.errores = errores;
    }

}