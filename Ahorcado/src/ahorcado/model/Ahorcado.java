/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.model;

/**
 *
 * @author daw
 */
public class Ahorcado {
    public String palabraSecreta;
    public int errores;
    public boolean victoria;
    public String palabraAadivinarConGuiones;
    public String[] ArrayPalabraAadivinar;
    public final String[] palabras={
        
    };//poner palabras en el String
    
    /**
     * Construtor por defecto
     */
    public Ahorcado(){
        
    }
    
    /**
     * Getter de errores
     * @return el numero de errores que llevas
     */
     public Integer getNumErrores() {
        return errores;
    }
    /**
     * Setter de errores
     * @param errores 
     */
    public void setFallos(Integer errores) {
        this.errores = errores;
    }
    
    /**
     * Metodo que suma 1 a los errores
     */
    public void AumentarError() {

        this.errores += 1;

    }
    /**
     * Getter de la palabra a adivinar 
     * @return 
     */
      public String getPalabraSecreta() {
        return palabraSecreta;
    }
      
      /**
       * Metodo que dependiendo de la palabra secreta genera los guiones 
       * necesario y genera un array de String en el que esta la palabra secreta 
       * separada en caracteres
       */
       public void ocultarPalabra () {
        StringBuilder paOculta = new StringBuilder();/*Nota el StringBuilder es 
        similar al String pero agrega cosas como el .append que añada al
        final del String algo  
        */
        int nLetras = palabraSecreta.length();
        String[] palabraOculta = new String[nLetras];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = "_";
            paOculta.append("_ ");
        }
        this.palabraAadivinarConGuiones = paOculta.toString();
        this.ArrayPalabraAadivinar = palabraOculta;
    }
       
       /**
        * Getter del String palabraAadivinarConGuiones
        * @return palabraAadivinarConGuiones
        */
       public String getpalabraAadivinarConGuiones(){
           return palabraAadivinarConGuiones;
       }
       /**
        * Getter del String[] getArrayPalabraAadivinar
        * @return getArrayPalabraAadivinar
        */
       public String[] getArrayPalabraAadivinar(){
           return ArrayPalabraAadivinar;
       }
       /**
        * Setter del String palabraAadivinarConGuiones
        * @return palabraAadivinarConGuiones
        */
       public void  setpalabraAadivinarConGuiones(String palabraActualizada){
           this.palabraAadivinarConGuiones=palabraActualizada;
       }

       /**
        * Setter del String[] getArrayPalabraAadivinar
        * @return getArrayPalabraAadivinar
        */
       public void setArrayPalabraAadivinar(String[] ArrayPalabraActualizada){
           this.ArrayPalabraAadivinar=ArrayPalabraActualizada;
       }
       
       public String obtenerPalabraSecreta(){
           int[] lenArrays = new int[palabras.length];
        int finalLength = 0;
        for (int i = 0; i < palabras.length; i++) {
            finalLength += palabras[i].length();
            lenArrays[i] = palabras[i].length();
        }

        // POSICIÓN ALEATORIA EN LA LONGITUD GLOBAL
        int posTotal = (int) (Math.random() * finalLength);
        
           // establece a qué array pertenece esa posicion
        int sumatorio = 0;
        int contadorSet = 0;
        int acumulado = 0;
        for (int lenArray : lenArrays) {
            sumatorio += lenArray;
            if (sumatorio > posTotal) {
                break;
            } else {
                contadorSet += 1;
                acumulado += lenArray;
            }
        }

        // establece la posición en el array
        int posSet = posTotal - acumulado;
        int[] arraypalabras;
        arraypalabras = new int[] (posSet);
 
        
           int[] valorPalabra = new int[] (posSet);
       }
       
       
}
