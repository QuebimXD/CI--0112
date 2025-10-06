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
         System.out.println("CARTERA");
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
                ataq.setPpActualA(ataq.getPpActualA() -1);
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
                System.out.println("Comienza el combate contra : " + entrenador.getNombreE());
                for(int j = 0; j < entrenador.largoListaP(); j++){
                    Pokemon pokeUsuario = elegirPokemonUsuario(usuario);
                    Pokemon pokeNPC = entrenador.getEquipoPokemon(j);
                    combate(pokeUsuario, pokeNPC);

            }
            }
            
            
        }
    }



    public void combate(Pokemon p1, Pokemon p2){
        Ataque ataqueElegido = null;
        int danio =0;
        if(p1.getVelocidadP() >= p2.getVelocidadP()){
            ataqueElegido = elegirAtaque(p1);
            danio = (((2 * p1.getNivelP() / 5 + 2)* ataqueElegido.getPotenciaA() * ataqueElegido.getPrecisionA()/ p2.getDefensaP())/ 50) + 2;
            p2.setVidaP(p2.getVidaP() - danio);
           

            if(p2.getVidaP() > 0){
                ataqueElegido = ataqueNPC(p2);
                danio = (((2 * p2.getNivelP() / 5 + 2)* ataqueElegido.getPotenciaA() * ataqueElegido.getPrecisionA()/ p1.getDefensaP())/ 50) + 2;
                p1.setVidaP(p1.getVidaP() - danio);
            }
         
        }else {
            ataqueElegido = ataqueNPC(p2);
            danio = (((2 * p2.getNivelP() / 5 + 2)* ataqueElegido.getPotenciaA() * ataqueElegido.getPrecisionA()/ p1.getDefensaP())/ 50) + 2;
            p1.setVidaP(p1.getVidaP() - danio);
            

            if(p1.getVidaP() > 0){
                ataqueElegido = elegirAtaque(p1);
                danio = calcularDanio(p1.getNivelP(), ataqueElegido.getPotenciaA(), ataqueElegido.getPrecisionA(), p2.getDefensaP());
                p2.setVidaP(p2.getVidaP() - danio);
            }  
        }
        System.out.println("Vida de " + p1.getNombreP() + " : " + p1.getVidaP());
        System.out.println("Vida de " + p2.getNombreP() + " : " + p2.getVidaP());
    }

    public int calcularDanio(int nivel, int potencia, int precision, int defensa){
        int danio = 0;
        danio = (int)((((2 * nivel / 5 + 2)* potencia * precision/ defensa)/ 50) + 2);
        return danio;
    }
            
    public void mostrarEntrenadores(){
        for (int i = 0; i < entrenadores.length; i++){
            Entrenador e = entrenadores[i];
            System.out.println("Nombre: " +  e.getNombreE());
        }
    }

}