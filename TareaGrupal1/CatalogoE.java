/*
 * Esta es la clase que crea el catálogo de Elementos.
 * @ RodrigoLovers
 * @version 1.0
 */


public class CatalogoE{

    //Esta clase trae todo el catalogo de los elementos posibles. 
    //De esta manera, para llamar cada elemento al ataque, usamos los getters.

    public CatalogoE(){

    } // Constructor vacio

    public Elemento fuego = new Elemento("Fuego", "Agua", "Planta");
    public Elemento agua = new Elemento("Agua", "Planta", "Fuego");
    public Elemento planta = new Elemento("Planta", "Fuego", "Agua");
    public Elemento electrico = new Elemento("Electrico", "Roca", "Agua");
    public Elemento veneno = new Elemento("Veneno", "Roca", "Planta");
    public Elemento roca = new Elemento("Roca", "Agua", "Veneno");
    public Elemento normal = new Elemento("Normal", "", "");

    /**
    * Retorna el elemento fuego
    *
    * @return objeto tipo Elemento
    */
    public Elemento getFuego(){
        return fuego;
    }

    /**
    * Retorna el elemento agua
    *
    * @return objeto tipo Elemento
    */
    public Elemento getAgua(){
        return agua;
    }
    /**
    * Retorna el elemento planta
    *
    * @return objeto tipo Elemento
    */
    public Elemento getPlanta(){
        return planta;
    }
    /**
    * Retorna el elemento electrico
    *
    * @return objeto tipo Elemento
    */
    public Elemento getElectrico(){
        return electrico;
    }
    /**
    * Retorna el elemento veneno
    *
    * @return objeto tipo Elemento
    */
    public Elemento getVeneno(){
        return veneno;
    }
    /**
    * Retorna el elemento roca
    *
    * @return objeto tipo Elemento
    */
    public Elemento getRoca(){
        return roca;
    }    /**
    * Retorna el elemento normal
    *
    * @return objeto tipo Elemento
    */
    public Elemento getNormal(){
        return normal;
    }
}