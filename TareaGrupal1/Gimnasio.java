import java.util.Random;
import java.util.Scanner;

public class Gimnasio {
    private Entrenador usuario;
    private String Ataque;
    private Pokemon pokemon;
    private Entrenador[] entrenadores;
    CatalogoP pokemones = new CatalogoP();

    public Gimnasio(){
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
        entrenadores = new Entrenador[4];
        entrenadores[0] = fuego;
        entrenadores[1] = agua;
        entrenadores[2] = planta;
        entrenadores[3] = lider; 
    }
    public Entrenador getEntrenador(int i){
        return entrenadores[i];
    }

    public Ataque elegirAtaque(Pokemon p){
        Scanner sc = new Scanner(System.in);
        int opt = -1;
        Ataque ataqueElegido = null;
        while(opt <= 1 || opt >= 4){
            System.out.println("Elija un ataque:");
            p.mostrarAtaques();
            opt = sc.nextInt();
            ataqueElegido = p.getAtaquesP(opt-1);
            if(ataqueElegido.getPpActualA() <= 0 ){
                System.out.println("Por favor elija otro ataque, no tiene PP disponibles");
                opt = -1;
            }else{
                ataqueElegido.setPpActualA(ataqueElegido.getPpActualA() -1);
            }
              
        } 
        return ataqueElegido;
    }

    public Ataque ataqueNPC(Pokemon p){
        boolean tienePp = false;
        Ataque ataq = null;
        while(tienePp == false){
            Random rand = new Random();
            int numA = rand.nextInt(4); // numero entre 0 y el 3
            ataq = p.getAtaquesP(numA);
            if(ataq.getPpActualA() <= 0){
                tienePp = false;
            }else{
                tienePp = true;
            }
        }
        return ataq;
    }

    public Pokemon elegirPokemonUsuario(Entrenador e){
        Scanner sc = new Scanner(System.in);
        int opt = -1;
        Pokemon pokemonElegido = null;
        while(opt <= 1 || opt >= 4){
            System.out.println("Elija un Pokemon:");
            e.mostrarEquipoPokemon();
            opt = sc.nextInt();
            pokemonElegido = e.getEquipoPokemon(opt-1);
            if(pokemonElegido.getVidaP() <= 0 ){
                System.out.println("Por favor elija otro Pokemon, no tiene Hp disponibles");
                opt = -1;
            }else{
                
            }
              
        } 
        return pokemonElegido;
    }
   
    public void logicaCombate(Entrenador usuario){

        for(int i = 0; i < entrenadores.length; i++){
            while(!(usuario.equipoDebilitado())){
                Entrenador entrenador = entrenadores[i];
                for(int j = 0; j < entrenador.largoListaP(); j++){
                    Pokemon pokeUsuario = elegirPokemonUsuario(usuario);
                    Pokemon pokeNPC = entrenador.getEquipoPokemon(j);
                combate(pokeUsuario, pokeNPC);
            }
            }
            
            
        }
    }



    public void combate(Pokemon p1, Pokemon p2){

        System.out.println("Comienza el combate");

        int entrenadoresDerrotados = 0;

        while(entrenadoresDerrotados < 4){

            if(usuario.equipoDebilitado()){
                System.out.println("¡Has perdido!");
                entrenadoresDerrotados = 5;
            }else{

                System.out.println("Es turno de combatir contra:" + entrenadores[entrenadoresDerrotados].getNombreE());

                Entrenador entrenador = entrenadores[entrenadoresDerrotados];

                Pokemon pokemonUsuario = usuario.getPrimerPokemon();
                Pokemon pokemonEntrenador = entrenador.getPrimerPokemon();
                if(pokemonUsuario.getVelocidadP() >= pokemonEntrenador.getVelocidadP()){
                    Ataque ataqueElegido = elegirAtaque(pokemonUsuario);
                    int danio = (((2 * pokemonUsuario.getNivelP() / 5 + 2)* ataqueElegido.getPotenciaA() * ataqueElegido.getPrecisionA()/ pokemonEntrenador.getDefensaP())/ 50) + 2;
                    pokemonEntrenador.setVidaP(pokemonEntrenador.getVidaP() - danio);
                }
            }
            
        }
        
    }

    public void mostrarEntrenadores(){
        for (int i = 0; i < entrenadores.length; i++){
            Entrenador e = entrenadores[i];
            System.out.println("Nombre: " +  e.getNombreE());
        }
    }

}