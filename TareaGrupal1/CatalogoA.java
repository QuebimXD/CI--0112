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

    public Ataque getAscuas(){
        return ascuas;
    }
    public Ataque getLanzallamas(){
        return lanzallamas;
    }

    public Ataque getPistolaAgua(){
        return pistolaAgua;
    }
    public Ataque getHidrobomba(){
        return hidrobomba;
    }

    public Ataque getLatigoCepa(){
        return latigoCepa;
    }
    public Ataque getHojaAfilada(){
        return hojaAfilada;
    }

    public Ataque getImpactrueno(){
        return impactrueno;
    }public Ataque getRayo(){
        return rayo;
    }

    public Ataque getPicotazoVeneno(){
        return picotazoVeneno;
    }public Ataque getColmilloVeneno(){
        return colmilloVeneno;
    }

    public Ataque getLanzarrocas(){
        return lanzarrocas;
    }
    public Ataque getRocaAfilada(){
        return rocaAfilada;
    }

    public Ataque getPlacaje(){
        return placaje;
    }
    public Ataque getAtaqueRapido(){
        return ataqueRapido;
    }
    public Ataque getGolpeCuerpo(){
        return golpeCuerpo;
    }
}