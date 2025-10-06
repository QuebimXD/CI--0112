/*
 * Esta es la clase que crea el catálogo de Ataques.
 * @ RodrigoLovers
 * @version 1.0
 */

public class CatalogoA{
    //Clase para establecer una lista fija de ataques, las cuales llama al catalogo de elementos
    CatalogoE catalogo = new CatalogoE();

    public CatalogoA(){} // Constructor vacio tambienn

    //Tipo fuego
    public Ataque ascuas = new Ataque("Ascuas", catalogo.getFuego(), 40, 25, 100);
    public Ataque lanzallamas = new Ataque("Lanzallamas", catalogo.getFuego(), 70, 15, 95);

    //Tipo agua
    public Ataque pistolaAgua = new Ataque("Pistola Agua", catalogo.getAgua(), 35, 30, 100);
    public Ataque hidrobomba = new Ataque("Hidrobomba", catalogo.getAgua(), 80, 15, 90);

    //Tipo planta
    public Ataque latigoCepa = new Ataque("Latigo Cepa", catalogo.getPlanta(), 45, 25, 100);
    public Ataque hojaAfilada = new Ataque("Hoja Afilada", catalogo.getPlanta(), 60, 25, 95);

    //Tipo Electrico
    public Ataque impactrueno = new Ataque("Impactrueno", catalogo.getElectrico(), 35, 30, 100);
    public Ataque rayo = new Ataque("Rayo", catalogo.getElectrico(), 90, 15, 95);

    //Tipo Veneno
    public Ataque picotazoVeneno = new Ataque("Picotazo Veneno", catalogo.getVeneno(), 35, 25, 100);
    public Ataque colmilloVeneno = new Ataque("Colmillo Veneno", catalogo.getVeneno(), 80, 15, 90);

    //Tipo roca
    public Ataque lanzarrocas = new Ataque("Lanzarrocas", catalogo.getRoca(), 50, 20, 95);
    public Ataque rocaAfilada = new Ataque("RocaAfila", catalogo.getRoca(),80, 15, 90);

    //Tipo Normal
    public Ataque placaje = new Ataque("Placaje", catalogo.getNormal(), 40, 25, 100);
    public Ataque ataqueRapido = new Ataque("Ataque Rapido", catalogo.getNormal(), 40, 30, 100);
    public Ataque golpeCuerpo = new Ataque("Golpe Cuerpo", catalogo.getNormal(), 50, 25, 95);
    
    //Estos getters para que cada ataque sea llamado al catalogo de los pokemons

    /**
    * Retorna el ataque ascuas
    *
    * @return objeto tipo Ataque
    */
    public Ataque getAscuas(){
        return ascuas;
    }
        /**
    * Retorna el ataque lanzallamas
    *
    * @return objeto tipo Ataque
    */
    public Ataque getLanzallamas(){
        return lanzallamas;
    }
    /**
    * Retorna el ataque pistolaAgua
    *
    * @return objeto tipo Ataque
    */
    public Ataque getPistolaAgua(){
        return pistolaAgua;
    }
        /**
    * Retorna el ataque Hidrobomba
    *
    * @return objeto tipo Ataque
    */
    public Ataque getHidrobomba(){
        return hidrobomba;
    }
        /**
    * Retorna el ataque latigoCepa
    *
    * @return objeto tipo Ataque
    */
    public Ataque getLatigoCepa(){
        return latigoCepa;
    }
        /**
    * Retorna el ataque hojaAfilada
    *
    * @return objeto tipo Ataque
    */
    public Ataque getHojaAfilada(){
        return hojaAfilada;
    }
    /**
    * Retorna el ataque ImpactoTrueno
    *
    * @return objeto tipo Ataque
    */
    public Ataque getImpactrueno(){
        return impactrueno;
    }
        /**
    * Retorna el ataque rayo
    *
    * @return objeto tipo Ataque
    */
    public Ataque getRayo(){
        return rayo;
    }
    /**
    * Retorna el ataque picotazoVeneno
    *
    * @return objeto tipo Ataque
    */
    public Ataque getPicotazoVeneno(){
        return picotazoVeneno;
    }
        /**
    * Retorna el ataque colmilloVeneno
    *
    * @return objeto tipo Ataque
    */
    public Ataque getColmilloVeneno(){
        return colmilloVeneno;
    }
    /**
    * Retorna el ataque lanzarrocas
    *
    * @return objeto tipo Ataque
    */
    public Ataque getLanzarrocas(){
        return lanzarrocas;
    }
        /**
    * Retorna el ataque rocaAfilada
    *
    * @return objeto tipo Ataque
    */
    public Ataque getRocaAfilada(){
        return rocaAfilada;
    }
    /**
    * Retorna el ataque placaje
    *
    * @return objeto tipo Ataque
    */
    public Ataque getPlacaje(){
        return placaje;
    }
        /**
    * Retorna el ataque ataqueRapido
    *
    * @return objeto tipo Ataque
    */
    public Ataque getAtaqueRapido(){
        return ataqueRapido;
    }
        /**
    * Retorna el ataque golpeCuerpo
    *
    * @return objeto tipo Ataque
    */
    public Ataque getGolpeCuerpo(){
        return golpeCuerpo;
    }
}