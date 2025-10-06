/*
 * Esta es la clase modelo de Ataque.
 * @ RodrigoLovers
 * @version 1.0
 */

public class Ataque{
    private String nombreA;
    private Elemento elementoA;
    private int potenciaA;
    private int ppMaxA;
    private int ppActualA;
    private int precisionA;

/**
 *  Constructor de clase Ataque.
 * 
 * @param n nombre del ataque
 * @param e elemento del ataque
 * @param pot potencia del ataque
 * @param pM potencia actual del ataque
 * @param pre precision del ataque
 */
    public Ataque(String n, Elemento e, int pot, int pM, int pre){
        this.nombreA = n;
        this.elementoA = e;
        this.potenciaA = pot;
        this.ppActualA = pM; //El pp actual es el maximo al inicio de cada Pokemon >:D
        this.precisionA = pre;
    }

    /**
    * Retorna el nombre del ataque
    *
    * @return el nombre del ataque
    */

    public String getNombreA(){
        return nombreA;
    }
    
    /**
    * Retorna el elemento del ataque
    *
    * @return el elemento del ataque
    */
    public Elemento getElementoA(){
        return elementoA;
    }
    
    /**
    * Retorna la potencia del ataque
    *
    * @return la potencia del ataque
    */
    public int getPotenciaA(){
        return potenciaA;
    }
    
    /**
    * Retorna el pp máximo del ataque
    *
    * @return el pp máximo  del ataque
    */
    public int getPpMaxA(){
        return ppMaxA;
    }
    
    /**
    * Retorna el pp actual del ataque
    *
    * @return el pp actual del ataque
    */
    public int getPpActualA(){
        return ppActualA;
    }
    
    /**
    * Retorna la precision del ataque
    *
    * @return la precision del ataque
    */
    public int getPrecisionA(){
        return precisionA;
    }
    
    /**
    * Asigna el nombre del ataque
    *
    * @param n nombre a asignar
    */
    public void setNombreA(String n){
        this.nombreA = n;
    }
        /**
    * Asigna el elemento del ataque
    *
    * @param e elemento a asignar
    */
    public void setElementoA(Elemento e){
        this.elementoA = e;
    }
        /**
    * Asigna la potencia del ataque
    *
    * @param p potencia a asignar
    */
    public void setPotenciaA(int p){
        this.potenciaA = p;
    }
        /**
    * Asigna el pp máximo del ataque
    *
    * @param p pp máximo a asignar
    */
    public void setPpMaxA(int p){
        this.ppMaxA = p;
    }
        /**
    * Asigna el pp actual del ataque
    *
    * @param a pp actual a asignar
    */
    public void setPpActualA(int a){
        this.ppActualA = a;
    }
        /**
    * Asigna la precision del ataque
    *
    * @param pr nombre a asignar
    */
    public void setPrecisionA(int pr){
        this.precisionA = pr;
    }


}   
