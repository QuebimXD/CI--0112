import java.util.Random;
import java.util.Scanner;


/*
 * Clase de tipo Controlador de Gimnasio
 */
public class Gimnasio {
    private Entrenador usuario;
    private Pokemon pokemon;
    private Entrenador[] entrenadores;
    CatalogoP pokemones = new CatalogoP();

    //Variables para el resumen
    private int rivalesDerrotados;
    private int pokemonesDerrotadosR;
    private int pokemonesDerrotadosU;
    private int gymVencidos;
    private int derrotas;



    /**
     * Constructor de Gimnasio
     * Se inicializan los contadores como 0 y se inicializa y guardan los entrenadores y la lista de entrenadores respectivamente.
     */
    public Gimnasio(){

        this.rivalesDerrotados = 0;
        this.pokemonesDerrotadosR =0;
        this.pokemonesDerrotadosU =0;
        this.gymVencidos =0;
        this.derrotas =0;

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

    /**
     * Getter de contador de rivales derrotados
     * @return la variable de rivales derrotados
     */
    public int getRivalesDerrotadosR(){
        return rivalesDerrotados;
    }
    /**
     * Getter de contador de pokemonnes rivales derrotados
     * @return la variable de pokemones rivales derrotados
     */
    public int getPokemonesDerrotadosR(){
        return pokemonesDerrotadosR;
    }
    /**
     * Getter de contador de pokemones del usuario derrotados
     * @return la variable de pokemones del usuario derrotados
     */
    public int getPokemonesDerroratosU(){
        return pokemonesDerrotadosU;
    }
    /**
     * Getter de contador de veces que se pasa el gimnasio
     * @return la variable de gymVencidos
     */
    public int getGymVencidos(){
        return gymVencidos;
    }
    /**
     * Getter de contador de veces que se pierde en el gimnasio
     * @return la variable de contador de derrotas
     */
    public int getDerrotas(){
        return derrotas;
    }
    /**
     * Getter que retorna un entrenador de la lista
     * @param i el indice del entrenador a buscar
     * @return el entrenador i de la lista
     */
    public Entrenador getEntrenador(int i){
        return entrenadores[i];
    }
    /**
     * Setter del usuario para aplicar en el Menu
     * @param u el entrenador usuario
     */
    public void setUsuario(Entrenador u){
        this.usuario = u;
    }

    /**
     * Metodo para que el  usuario elija el ataque del pokemon. Abre un mini menu para que el usuario escoja un ataque. Verifica si los pp son positivos, sino manda al jugador a elegir otro.
     * @param p el pokemon del que se va a elegir el ataque
     * @param u el duenio del pokemon parametro
     * @return el ataque que eligio el jugador
     */
    public Ataque elegirAtaque(Pokemon p, Entrenador u){
        Scanner sc = new Scanner(System.in);
        int opt = -1;
        Ataque ataqueElegido = null;
        try{
            while(opt <= 0 || opt > 4){
                System.out.println("Elija un ataque:"  + "\n");
                p.mostrarAtaques();
                opt = sc.nextInt();
                while(opt > 4){
                    System.out.println("Número incorrecto, vuelva elegir una opción \n");
                    opt = sc.nextInt();
                }
                ataqueElegido = p.getAtaquesP(opt-1);
                
                if(ataqueElegido.getPpActualA() <= 0){
                    System.out.println("Por favor elija otro ataque, no tiene PP disponibles"  + "\n");
                    opt = -1;
                }else{
                    ataqueElegido.setPpActualA(ataqueElegido.getPpActualA() -1);
                }
            } 
        }catch(Exception e){
            System.err.println("Oh no, ha fallado por: " + e);
        }
        
        return ataqueElegido;
    }

    /**
     * Metodo para que el NPC escoja el ataque de su pokemon de manera automatica. Randomiza un numero entre 0 y 3 para escoger el ataque del indice de la lista de ataques del pokemon del NPC
     * @param p el pokemon del que se extrae el ataque
     * @return el ataque que se escogio de manera aleatoria
     */
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

    /**
     * Metodo para que el usuario cambie de pokemon mientras esta en combate. Abre un mini menu que se encarga de hacer al usuario elegir el pokemon.
     * @param e el entrenador usuario.
     * @return el pokemon que va a ser cambiado durante el combate.
     */
    public Pokemon elegirPokemonUsuario(Entrenador e){
        boolean elegido = false;
        Pokemon pokemonE = null;
        Scanner sc = new Scanner(System.in);
        int opt = -1;
        try{
            while(elegido == false){
                System.out.println("Elija un Pokemon:" + "\n");
                e.mostrarEquipoPokemon();
                opt = sc.nextInt();
                while(opt > 3){
                    System.out.println("Número incorrecto, vuelva elegir una opción \n");
                    opt = sc.nextInt();
                }
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
        }catch(Exception ex){
            System.err.println("Oh no, ha fallado por: " + ex);
        }
        
        return pokemonE;
    }
    
    /**
     * Metodo para recorrer la logica de los combates. El for recorre la lista de entrenadores, que luego otro for recorre la lista de pokemones del rival. Verifica que tanto el NPC como el usuario no 
     * haya quedado con todo su equipo debilitado. Aqui contabiliza si gana el gimnasio, hay derrota y ademas los rivales vencidos.
     * @param usuario el usuario que se enfrenta a la lista de entrenadores
     * @return true si acaba el metodo o si el jugador vence a todos los rivales
     * @return false si el usuario pierde y se debilita todo su equipo.
     */
    public boolean logicaCombate(Entrenador usuario){
        int entrenadoresDerrotados = 0;

        for(int i = 0; i < entrenadores.length; i++){
            Entrenador entrenador = entrenadores[i];
            while(!usuario.equipoDebilitado() && verificacionNPCactivo(entrenador)){
                System.out.println("Comienza el combate contra : " + entrenador.getNombreE() + "\n");
                Pokemon pokeUsuario = elegirPokemonUsuario(usuario);

                for(int j = 0; j < entrenador.largoListaP(); j++){
                    Pokemon pokeNPC = entrenador.getEquipoPokemon(j);
                        
                    if(pokeNPC.getEstadoP() && !usuario.equipoDebilitado()){
                        combate(pokeUsuario, pokeNPC);
                    }                  
                }   
                if(!verificacionNPCactivo(entrenador)){
                    System.out.println("Has vencido a " + entrenador.getNombreE() + "\n");
                    rivalesDerrotados++;
                    entrenadoresDerrotados++;
                   
                }else if(usuario.equipoDebilitado()){
                    System.out.println("Tus tres pokemones se han debilitado, has perdido! \n");
                    derrotas++;
                }
            }
            if(entrenadoresDerrotados == 4 && !(usuario.equipoDebilitado())){
                System.out.println("FELICIDADESS!!! Has vencido a todos los entrenadores! \n");
                gymVencidos++;
                return true;
            } 
            curarEquipo(usuario);   
        }        
        return true;
    }

    /**
     * Metodo donde el pokemon del usuario y el del NPC se enfrentan. Veirica cual velocidad del pokemon es mayor y hace el calculo del danio, le resta la vida al pokemon afectado y luego imprime el ataque que realizo cada pokemon e imprime 
     * las vidas actualizadas. Al final si algun pokemon pierde toda su vida entonces se imprime el pokemon que ha sido derrotado
     * @param p1 el pokemon del usuario
     * @param p2 el pokemon del NPC
     * No retorna nada, pues es un metodo void
     */
    public void combate(Pokemon p1, Pokemon p2){
        Scanner sc = new Scanner(System.in);
        Ataque ataqueElegido = null;
        int danio =0;
        int opt = 0;
        try{
            while(p1.getVidaP() > 0 && p2.getVidaP() >0){
                System.out.println("1-Atacar \n2- Cambiar Pokemon" + "\n");
                opt = sc.nextInt();
                while(opt > 2){
                        System.out.println("Número incorrecto, vuelva elegir una opción");
                        opt = sc.nextInt();
                    }
                if(opt ==2){
                    p1 = elegirPokemonUsuario(usuario);
                    opt = 0;
                }

                if(p1.getVelocidadP() >= p2.getVelocidadP()){

                    if(opt != 2){
                        ataqueElegido = elegirAtaque(p1, usuario);
                        danio = calcularDanio(p1, p2, ataqueElegido);
                        p2.setVidaP(p2.getVidaP() - danio);
                    }

                    if(p2.getVidaP() > 0){
                        ataqueElegido = ataqueNPC(p2);
                        danio = calcularDanio(p2, p1, ataqueElegido);
                        p1.setVidaP(p1.getVidaP() - danio);
                    }

                }else{

                    ataqueElegido = ataqueNPC(p2);
                    danio = calcularDanio(p2, p1, ataqueElegido);
                    p1.setVidaP(p1.getVidaP() - danio);

                    if(p1.getVidaP() > 0 && opt !=2){
                        ataqueElegido = elegirAtaque(p1, usuario);
                        danio = calcularDanio(p1, p2, ataqueElegido);
                        p2.setVidaP(p2.getVidaP() - danio);
                    }  
                }
                //Despues de cada ataque se actualizan las vidas y se dice quien ha atacado
                System.out.println(p1.getNombreP() + " ha usado " + ataqueElegido.getNombreA() + "\n");
                System.out.println(p2.getNombreP() + " de rival ha usado " + ataqueElegido.getNombreA() + "\n");


                System.out.println("| Vida de " + p1.getNombreP() + " : " + p1.getVidaP());
                System.out.println("| Vida de " + p2.getNombreP() + " : " + p2.getVidaP() + "\n");

            }
        }catch(Exception exc){
            System.err.println("Oh no, ha fallado por: " + exc);
        }
        

        if(p1.getVidaP() <=0 && p1.getEstadoP()){
            p1.setEstadoP(false);
            System.out.println("Tu pokemon " + p1.getNombreP() + " Se ha debilitado :(" + "\n");
            pokemonesDerrotadosU++;
        }
        if(p2.getVidaP() <=0 && p2.getEstadoP()){
             p2.setEstadoP(false);
             System.out.println("El pokemon del rival " + p2.getNombreP() + " se ha debilitado" + "\n");
             pokemonesDerrotadosR++;
        }
    }

    /**
     * Metodo para calcular el danio del pokemon1 al pokemon 2. Verifica si la debilidad y fortaleza del pokemon a atacar coincide con el tipo del pokemon y la debilidad respectivamente para apliciar bufo o debufo
     * respectivamente. La formula sin cambios es: (((2 * nivel /2 +5) * potencia * preisicion / defensa de pokemon atacado) / 50 ) + 2 )
     * @param p1 el pokemon que hara danio que extrae fortaleza, debilidad y nivel
     * @param p2 el pokemon que sufrira el ataque del que se extrae su defensa
     * @param ataqueP1 el ataque del pokemon 1 de donde se extraen las stats de potencia y presicion
     */
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

    /**
     * Metodo iterativo que imprime el nombre de la lista de entrenadores
     * no retorna nada, es fijo
     */
    public void mostrarEntrenadores(){
        for (int i = 0; i < entrenadores.length; i++){
            Entrenador e = entrenadores[i];
            System.out.println("Nombre: " +  e.getNombreE());
        }
    }
    /**
     * Metodo para verificar que el npc sigue teniendo a alguno de sus pokemones vivos. Util para el while de la logica de combate
     * @param e el entrenador NPC
     * @return true si aun le queda al menos un pokemon con vida
     * @return false si ya no le quedan pokemones con vida
     */
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

    /**
     *Metodo para regenerar de manera iterativa la vida y los PP de cada pokemon del entrenador despues de haber derrotado a algun rival de la lista de entrenadores.
     @param e el entrenador usuario
     imprime un aviso de que ha curado los pokemones despues de vencer a cada rival para notificarle al usuario. 
     */
    public void curarEquipo(Entrenador e){
        for(int i = 0; i < e.largoListaP(); i++){
            Pokemon curando = usuario.getEquipoPokemon(i);
            curando.setVidaP(curando.getVidaMax());
            for(int j = 0; j < curando.longAtaques(); j++){
                curando.getAtaquesP(j).setPpActualA(curando.getAtaquesP(j).getPpMaxA());
            }
        }
        
        System.out.println("Has curado a tus pokemones \n");
    }


}