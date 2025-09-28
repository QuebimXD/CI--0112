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

    public Elemento getFuego(){
        return fuego;
    }
    public Elemento getAgua(){
        return agua;
    }
    public Elemento getPlanta(){
        return planta;
    }
    public Elemento getElectrico(){
        return electrico;
    }
    public Elemento getVeneno(){
        return veneno;
    }
    public Elemento getRoca(){
        return roca;
    }
    public Elemento getNormal(){
        return normal;
    }
}