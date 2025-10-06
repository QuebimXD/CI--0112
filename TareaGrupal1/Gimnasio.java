import java.util.Random;
import java.util.Scanner;

public class Gimnasio {
    private boolean cambiar;
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
    public void setUsuario(Entrenador u){
        this.usuario = u;
    }

    public Ataque elegirAtaque(Pokemon p, Entrenador u){
        Scanner sc = new Scanner(System.in);
        int opt = -1;
        Ataque ataqueElegido = null;
        while(opt <= 0 || opt > 4){
            System.out.println("Elija un ataque:"  + "\n");
            p.mostrarAtaques();
            opt = sc.nextInt();
            ataqueElegido = p.getAtaquesP(opt-1);
            
            if(ataqueElegido.getPpActualA() <= 0){
                System.out.println("Por favor elija otro ataque, no tiene PP disponibles"  + "\n");
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
        if(e.equipoDebilitado()){
            System.out.println("Te has quedado sin pokemones");
            return null;
        }
        boolean elegido = false;
        Pokemon pokemonE = null;
        Scanner sc = new Scanner(System.in);
        int opt = -1;
        
        while(elegido == false){
            System.out.println("Elija un Pokemon:" + "\n");
            e.mostrarEquipoPokemon();
            opt = sc.nextInt();

            if(opt >=1 && opt <= e.largoListaP()){
                pokemonE = e.getEquipoPokemon(opt-1);
                if(pokemonE.getVidaP() >0 ){
                    System.out.println("Has elegido a " + pokemonE.getNombreP() + "\n");
                    elegido = true;
                }else{
                    System.out.println("Este pokemon no tiene vida :(" + "\n");
                    elegido = false;
                }
            }else{
                System.out.println("Escoja un numero entre las opciones" + "\n");
                elegido = false;
            }
        }
        return pokemonE;
    }
   
    public void logicaCombate(Entrenador usuario){
        boolean gymActivo = true;
        while(gymActivo){
            for(int i = 0; i < entrenadores.length; i++){
                Entrenador entrenador = entrenadores[i];
                System.out.println("Comienza el combate contra : " + entrenador.getNombreE() + "\n");

                while(!usuario.equipoDebilitado() && verificacionNPCactivo(entrenador)){
                    Pokemon pokeUsuario = elegirPokemonUsuario(usuario);
                    for(int j = 0; j < entrenador.largoListaP(); j++){
                        Pokemon pokeNPC = entrenador.getEquipoPokemon(j);
                        
                        if(pokeNPC.getEstadoP()){
                            combate(pokeUsuario, pokeNPC);
                        }                  
                    }
                }   
            if(usuario.equipoDebilitado()){
                System.out.println("Te has quedado sin pokemones, gg");
                return;
            }
            System.out.println("Has vencido a " + entrenador.getNombreE());
        }
        System.out.println("Has vencido a todos los entrenadores");
        }
    }

    public void combate(Pokemon p1, Pokemon p2){
        Scanner sc = new Scanner(System.in);
        Ataque ataqueElegido = null;
        int danio =0;
        int opt = 0;

        while(p1.getVidaP() > 0 && p2.getVidaP() >0){
            System.out.println("1-Atacar \n2- Cambiar Pokemon" + "\n");
            opt = sc.nextInt();

            if(opt ==2){
                p1 = elegirPokemonUsuario(usuario);
                opt = 0;
            }

            if(p1.getVelocidadP() >= p2.getVelocidadP()){

                if(opt != 2){
                    ataqueElegido = elegirAtaque(p1, usuario);
                    danio = calcularDanio(p1, p2, ataqueElegido);
                    p2.setVidaP(p2.getVidaP() - danio);
                    System.out.println(p1.getNombreP() + " ha usado " + ataqueElegido.getNombreA() + "\n");
                }

                if(p2.getVidaP() > 0){
                    ataqueElegido = ataqueNPC(p2);
                    danio = calcularDanio(p2, p1, ataqueElegido);
                    p1.setVidaP(p1.getVidaP() - danio);
                    System.out.println(p2.getNombreP() + " de rival ha usado " + ataqueElegido.getNombreA() + "\n");
                }

            }else{

                ataqueElegido = ataqueNPC(p2);
                danio = calcularDanio(p2, p1, ataqueElegido);
                p1.setVidaP(p1.getVidaP() - danio);
                System.out.println(p2.getNombreP() + " de rival ha usado " + ataqueElegido.getNombreA() + "\n");

                if(p1.getVidaP() > 0 && opt !=2){
                    ataqueElegido = elegirAtaque(p1, usuario);
                    System.out.println(p1.getNombreP() + " ha usado " + ataqueElegido.getNombreA() + "\n");
                    danio = calcularDanio(p1, p2, ataqueElegido);
                    p2.setVidaP(p2.getVidaP() - danio);
                }  
            }
            //Despues de cada ataque se actualizan las vidass
            System.out.println("| Vida de " + p1.getNombreP() + " : " + p1.getVidaP());
            System.out.println("| Vida de " + p2.getNombreP() + " : " + p2.getVidaP() + "\n");

        }

        if(p1.getVidaP() <=0 ){
            p1.setEstadoP(false);
            System.out.println("Tu pokemon " + p1.getNombreP() + " Se ha debilitado :(" + "\n");
        }
        if(p2.getVidaP() <=0){
             p2.setEstadoP(false);
             System.out.println("El pokemon del rival " + p2.getNombreP() + " se ha debilitado" + "\n");
        }
    }


    public int calcularDanio(Pokemon p1, Pokemon p2, Ataque ataqueP1){
        int danio = 0;

        String fortalezaP1 = p1.getElementoP().getFortaleza();
        String debilidadP1 = p1.getElementoP().getFortaleza();
        if( debilidadP1.equals(p2.getElementoP().getNombreElemento())){
             danio = (int) ( (0.90) * (((2 * p1.getNivelP() / 5 + 2)*  ataqueP1.getPotenciaA() * ataqueP1.getPrecisionA() / p2.getDefensaP())/ 50) + 2 );
        }else if(fortalezaP1.equals(p2.getElementoP().getDebilidad())){
             danio = (int) ( (1.10) * (((2 * p1.getNivelP() / 5 + 2)* ataqueP1.getPotenciaA() * ataqueP1.getPrecisionA() / p2.getDefensaP())/ 50) + 2 );
        }else{
            danio = (int) ((((2 * p1.getNivelP() / 5 + 2)* ataqueP1.getPotenciaA() * ataqueP1.getPrecisionA() / p2.getDefensaP())/ 50) + 2 );
        }
        return danio;
    }

    public void mostrarEntrenadores(){
        for (int i = 0; i < entrenadores.length; i++){
            Entrenador e = entrenadores[i];
            System.out.println("Nombre: " +  e.getNombreE());
        }
    }

    public boolean verificacionNPCactivo(Entrenador e){
        int contador = 0;
        for(int i = 0; i < e.largoListaP(); i++){
            if(e.getEquipoPokemon(i).getEstadoP() == false){
                contador ++;
            }
        }
        if(contador == e.largoListaP()){
            return false;
        }
        return true;
    }
    

}