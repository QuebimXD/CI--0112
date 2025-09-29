public class CatalogoP{

    private Pokemon[] listaP;

    //Lista de pokemones, llama al catalogo de ataques para que cada pokemon tenga una lista de ataques
    CatalogoA ataques = new CatalogoA();
    CatalogoE elementos = new CatalogoE();

    public CatalogoP(){
        listaP[0]= charizard;
        listaP[1]= blastoise;
        listaP[2] = venusaur;
        listaP[3] = pickachu;
        listaP[4] = nidoking;
        listaP[5] = snorlax;
        listaP[6] = arcanine;
        listaP[7] = jolteon;
        listaP[8] = rhydon;
        listaP[9] = arbok;
    }

            Pokemon charizard = new Pokemon("Charizard", 50, 200, elementos.getFuego(), 84, 78, 100, true, 
            new Ataque[] {
                ataques.getAscuas(),
                ataques.getLanzallamas(),
                ataques.getPlacaje(),
                ataques.getAtaqueRapido()
            });
            Pokemon blastoise = new Pokemon("Blastoise", 55, 210, elementos.getAgua(), 83, 100, 78, true, 
            new Ataque[] {
                ataques.getPistolaAgua(),
                ataques.getHidrobomba(),
                ataques.getPlacaje(),
                ataques.getGolpeCuerpo()
            });
            Pokemon venusaur = new Pokemon("Venusaur", 60, 220, elementos.getPlanta(), 82, 83, 80, true, 
            new Ataque[] {
                ataques.getLatigoCepa(),
                ataques.getHojaAfilada(),
                ataques.getPlacaje(),
                ataques.getGolpeCuerpo()
            });
            Pokemon pickachu = new Pokemon("Pickachu", 45, 180, elementos.getElectrico(), 55, 40, 110, true, 
            new Ataque[] {
                ataques.getImpactrueno(),
                ataques.getRayo(),
                ataques.getPlacaje(),
                ataques.getAtaqueRapido()
            });
            Pokemon nidoking = new Pokemon("Nidoking", 48, 190, elementos.getVeneno(), 90, 85, 85, true, 
            new Ataque[] {
                ataques.getPicotazoVeneno(),
                ataques.getColmilloVeneno(),
                ataques.getPlacaje(),
                ataques.getGolpeCuerpo()
            });
            Pokemon snorlax = new Pokemon("Snorlax", 50, 290, elementos.getNormal(), 110, 65, 30, true, 
            new Ataque[] {
                ataques.getPlacaje(),
                ataques.getGolpeCuerpo(),
                ataques.getAtaqueRapido(),
                ataques.getImpactrueno()
            });
            Pokemon arcanine = new Pokemon("Arcanine", 47, 200, elementos.getFuego(), 100, 80, 95, true, 
            new Ataque[] {
                ataques.getAscuas(),
                ataques.getLanzallamas(),
                ataques.getGolpeCuerpo(),
                ataques.getAtaqueRapido()
            });
            Pokemon jolteon = new Pokemon("Jolteon", 46, 150, elementos.getElectrico(), 65, 60, 130, true, 
            new Ataque[] {
                ataques.getImpactrueno(),
                ataques.getRayo(),
                ataques.getPlacaje(),
                ataques.getAtaqueRapido()
            });
            Pokemon rhydon = new Pokemon("Rhydon", 49, 230, elementos.getRoca(), 105, 120, 40, true, 
            new Ataque[] {
                
                ataques.getLanzarrocas(),
                ataques.getRocaAfilada(),
                ataques.getPlacaje(),
                ataques.getGolpeCuerpo()
            });
            Pokemon arbok = new Pokemon("Arbok", 50, 170, elementos.getVeneno(), 85, 70, 80, true,
            new Ataque[]{
                ataques.getPicotazoVeneno(),
                ataques.getColmilloVeneno(),
                ataques.getPlacaje(),
                ataques.getAtaqueRapido()
            });

       

    
}