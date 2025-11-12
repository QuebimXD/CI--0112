/*
 * Esta es la clase de los nodos del arbol
 * @ RodrigoLovers
 * @version 1.0
 */

public class NodoArbol {
    private String color;
    private int frecuencia;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    /**
     * Metodo constructor que inicializa los nodos izquierdo y derecho del inicial como nulos, el color correspondiente, 0 de frecuencia.
     * @param color el color del arbol que sera imputado.
     */
    public NodoArbol(String color){
        this.color = color;
        this.frecuencia = 0;
        this.izquierdo = null;
        this.derecho = null;
    }

    /**
     * Metodo getter de el color del nodo.
     * @return el color del nodo.
     */
    public String getColor(){
        return color;
    }
    /**
     * Metodo getter de cuantas veces aparece un bloque del respectivo color del nodo.
     * @return la frecuencia con la que aparece.
     */
    public int getFrecuencia(){
        return frecuencia;
    }
    /**
     * Metodo que retorna la referencia a la que esta ligado el nodo izquierdo del arbol.
     * @return el nodo izquierdo de este nodo del arbol.
     */
    public NodoArbol getIzquierdo(){
        return izquierdo;
    }
    /**
     * Metodo que retorna la referenca a la que esta ligado el nodo derecho del arbol.
     * @return el nodo derecho de este nodo del arbol.
     */
    public NodoArbol getDerecho(){
        return derecho;
    }

    /**
     * Metodo setter del color del nodo.
     * @param c el color que sera cambiado.
     */
    public void setColor(String c){
        this.color = c;
    }
    /**
     * Metodo setter de la frecuencia de este color.
     * @param f la frecuencia, entero no negativo.
     */
    public void setFrecuencia(int f){
        this.frecuencia = f;
    }
    /**
     * Metodo para manipular la referencia del nodo izquierdo de este color.
     * @param i el nodo izquierdo de esta rama.
     */
    public void setIzquierdo(NodoArbol i){
        this.izquierdo = i;
    }
    /**
     * Metodo para manipular la referencia del nodo derecho de este color.
     * @param d el nodo derecho de esta rama.
     */
     public void setDerecho(NodoArbol d){
        this.derecho = d;
    }
}
