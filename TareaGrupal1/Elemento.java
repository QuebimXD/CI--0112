/**
 * Esta es la clase modelo de Elemento.
 * @ RodrigoLovers
 * @version 1.0
 */


public class Elemento {
    private String nombre;
    private String debilidad;
    private String fortaleza;
    private Elemento[] catalogo;

/**
 *  Constructor de clase Elemento.
 * 
 * @param nombre nombre del elemento
 * @param debilidad debilidad del elemento
 * @param fortaleza fortaleza del elemento
 */

    public Elemento(String nombre, String debilidad, String fortaleza ){
            this.nombre = nombre;
            this.debilidad = debilidad;
            this.fortaleza = fortaleza;
            this.catalogo = new Elemento[6];
    }

    /**
    * Asigna el nombre del elemento
    *
    * @param nombre nombre del elemento
    */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
    * Asigna la debilidad del elemento
    *
    * @param debilidad debilidad del pokemon
    */
    public void setDebilidades(String debilidad){
        this.debilidad = debilidad;
    }
    /**
    * Asigna la fortaleza del elemento
    *
    * @param fortaleza fortaleza del pokemon
    */
    public void setFortaleza(String fortaleza){
        this.fortaleza = fortaleza;
    }
    /**
    * Retorna el nombre del elemento
    *
    * @return nombre del pokemon
    */
    public String getNombreElemento(){
        return nombre;
    }
    /**
    * Retorna la debilidad del elemento
    *
    * @return  debilidad debilidad del pokemon
    */
    public String getDebilidad(){
        return debilidad;
    }
        /**
    * Retorna la fortaleza del elemento
    *
    * @return fortaleza del pokemon
    */
    public String getFortaleza(){
        return fortaleza;
    }
}
