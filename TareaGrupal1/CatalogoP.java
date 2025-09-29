public class CatalogoP{
    public CatalogoP(){}

    //Lista de pokemones, llama al catalogo de ataques para que cada pokemon tenga una lista de ataques
    CatalogoA ataques = new CatalogoA();
    CatalogoE elementos = new CatalogoE();

    public Pokemon charizard = new Pokemon("Charizard", 50, 200, elementos.getFuego(), 84, 78, 100, true, 
    new Ataque[] {
        ataques.getAscuas(),
        ataques.getLanzallamas(),
        ataques.getPlacaje(),
        ataques.getAtaqueRapido()
    });
    public Pokemon blastoise = new Pokemon("Blastoise", 55, 210, elementos.getAgua(), 83, 100, 78, true, 
    new Ataque[] {
        ataques.getPistolaAgua(),
        ataques.getHidrobomba(),
        ataques.getPlacaje(),
        ataques.getGolpeCuerpo()
    });
    public Pokemon venusaur = new Pokemon("Venusaur", 60, 220, elementos.getPlanta(), 82, 83, 80, true, 
    new Ataque[] {
        ataques.getLatigoCepa(),
        ataques.getHojaAfilada(),
        ataques.getPlacaje(),
        ataques.getGolpeCuerpo()
    });
    public Pokemon pickachu = new Pokemon("Pickachu", 45, 180, elementos.getElectrico(), 55, 40, 110, true, 
    new Ataque[] {
        ataques.getImpactrueno(),
        ataques.getRayo(),
        ataques.getPlacaje(),
        ataques.getAtaqueRapido()
    });
    public Pokemon nidoking = new Pokemon("Nidoking", 48, 190, elementos.getVeneno(), 90, 85, 85, true, 
    new Ataque[] {
        ataques.getPicotazoVeneno(),
        ataques.getColmilloVeneno(),
        ataques.getPlacaje(),
        ataques.getGolpeCuerpo()
    });
    public Pokemon snorlax = new Pokemon("Snorlax", 50, 290, elementos.getNormal(), 110, 65, 30, true, 
    new Ataque[] {
        ataques.getPlacaje(),
        ataques.getGolpeCuerpo(),
        ataques.getAtaqueRapido(),
        ataques.getImpactrueno()
    });
    public Pokemon arcanine = new Pokemon("Arcanine", 47, 200, elementos.getFuego(), 100, 80, 95, true, 
    new Ataque[] {
        ataques.getAscuas(),
        ataques.getLanzallamas(),
        ataques.getGolpeCuerpo(),
        ataques.getAtaqueRapido()
    });
    public Pokemon jolteon = new Pokemon("Jolteon", 46, 150, elementos.getElectrico(), 65, 60, 130, true, 
    new Ataque[] {
        ataques.getImpactrueno(),
        ataques.getRayo(),
        ataques.getPlacaje(),
        ataques.getAtaqueRapido()
    });
    public Pokemon rhydon = new Pokemon("Rhydon", 49, 230, elementos.getRoca(), 105, 120, 40, true, 
    new Ataque[] {
        
        ataques.getLanzarrocas(),
        ataques.getRocaAfilada(),
        ataques.getPlacaje(),
        ataques.getGolpeCuerpo()
    });
    public Pokemon arbok = new Pokemon("Arbok", 50, 170, elementos.getVeneno(), 85, 70, 80, true,
    new Ataque[]{
        ataques.getPicotazoVeneno(),
        ataques.getColmilloVeneno(),
        ataques.getPlacaje(),
        ataques.getAtaqueRapido()
    }
    );
}