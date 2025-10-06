import java.util.Random;
public class Gimnasio {
    private String NombreEU;
    private Entrenador usuario;
    private String Ataque;
    private Pokemon pokemon;
    private Entrenador[] entrenadores;
    CatalogoP pokemones = new CatalogoP();

    public Gimnasio(){
        NombreEU = "";
    entrenadores = new Entrenadores[4] = {fuego, agua, planta, lider};
    Entrenador fuego = new Entrenador("Axel Llama", 
    new Pokemon[]{
            pokemones.getListaP(0),
            pokemones.getListaP(6)
    });
    Entrenador agua = new Entrenador("Mariana Azul", 
    new Pokemon[]{
            pokemones.getListaP(1),
            pokemones.getListaP(10)
    });
    Entrenador planta = new Entrenador("Raimundo Raiz", 
    new Pokemon[]{
            pokemones.getListaP(2),
            pokemones.getListaP(11)
    });
    Entrenador lider = new Entrenador("Violeta Prisma", 
    new Pokemon[]{
            pokemones.getListaP(4),
            pokemones.getListaP(7),
            pokemones.getListaP(8)
    });
}


    }
    public void setNombreEntrenador(String nombreU){
        NombreEU = nombreU;
    }
    public String getNombreEntrenador(){
        return NombreEU;
    }
    public Ataque elegirAtaque(){
        System.out.println("Elija un ataque:");
        Ataque ataque = null;

        return ataque;
    
    }


    public void ataqueNPC(){
        Random rand = new Random();
        int numA = rand.nextInt(4); // numero entre 0 y el 3

    }

    public void mostrarEntrenadores(){

    }
    public void combate(){
        System.out.println("Comienza el combate");
        int entrenadoresDerrotados = 0;
        while(entrenadoresDerrotados < 4){
            if(usuario.equipoDebilitado()){
                System.out.println("¡Has perdido!");
                entrenadoresDerrotados = 5;
            }
            else{
                System.out.println("Es turno de combatir contra:" + entrenadores[entrenadoresDerrotados].getNombre());
                Entrenador entrenador = entrenadores[entrenadoresDerrotados];
                Pokemon pokemonUsuario = usuario.getPrimerPokemon();
                Pokemon pokemonEntrenador = entrenador.getPrimerPokemon();
                if(pokemonUsuario.getVelocidad() >= pokemonEntrenador.getVelocidad()){
                    Ataque ataqueElegido = elegirAtaque();
                    int danio = (((2 * pokemonUsuario.getNivelP() / 5 + 2)* ataqueElegido.getPotenciaA() * ataqueElegido.getPrecisionA()/ pokemonEntrenador.getDefensaP())/ 50) + 2;
                    pokemonEntrenador.setVida(pokemonEntrenador.getVidaP() - danio);
                }
            }
            
        }
        
    }

}