import java.util.Scanner;
public class Menu{
    private Entrenador usuario;
    private Gimnasio gimnasio;
    private CatalogoP pokemones = new CatalogoP();

    public Menu(){
        long inicio = System.nanoTime();
        double duracionSegundos = 0;
        usuario = new Entrenador("");
        gimnasio = new Gimnasio();
        String nombre = "";
        Scanner scanner = new Scanner(System.in);
        gimnasio.setUsuario(usuario);

        System.out.println("¡Bienvenido al gimmnasio pokemon!");
        System.out.println("Por favor, escriba su nombre:");
        nombre = scanner.nextLine();
        usuario.setNombreE(nombre);
        System.out.println("Escoja a sus tres pokemon iniciales:");
        seleccionJugador();

        int opcion = 0;
        while (opcion <= 0){
            System.out.println("Empecemos el juego. Escoja una de las siguientes opciones:\n " +
                              "1-Entrar al gimnasio.\n 2-Ver a los entrenadores\n " +
                              "3-Ver mis pokemones y sus estadísticas.\n " +
                              "4-Salir"  + "\n");
            try {
                opcion = scanner.nextInt();
                if(opcion == 1){
                    System.out.println("Empieza tu primera batalla."  + "\n");
                    gimnasio.logicaCombate(usuario);
                    opcion = -1;

                    
                }
                else if (opcion == 2){
                    System.out.println("Esto son los entrenadores con los cuales vas a competir: "  + "\n");
                    gimnasio.mostrarEntrenadores();
                    opcion = -1;
                }
                else if (opcion == 3){
                    usuario.mostrarInfoEquipoPokemon();
                    opcion = -1;
                }
                else if (opcion == 4){
                    
                    System.out.println("Gracias por jugar Pokemon: Rodrigo Lovers");
                    long fin = System.nanoTime();
                    long duracionNano = fin - inicio;
                    duracionSegundos = (int)(duracionNano / 1_000_000_000.0);
                    System.out.println("Resumen de su juego \nSus rivales derrotados fueron: " + gimnasio.getRivalesDerrotadosR()  
                                        + "\nLos pokemones que derroto fueron: " + gimnasio.getPokemonesDerrotadosR() 
                                        + "\nSus pokemones derrotados fueron: " + gimnasio.getPokemonesDerroratosU()
                                        + "\nLos gimnasios que vencio fueron: " + gimnasio.getGymVencidos()
                                        + "\nLas derrotas que tuvo fueron: " + gimnasio.getDerrotas()
                                        + "\nEl tiempo jugado en segundos fue: " + duracionSegundos);
                }
                else if (opcion > 4){
                    
                    System.out.println("Escoja un número válido");
                    opcion = 0;
                }
            }
            catch (Exception e) {
                System.out.println("Escoja un número válido: "  + "\n");
                scanner.nextLine();
                opcion =0;
            }
        }   
    }

    public void seleccionJugador(){
        Scanner scanner = new Scanner(System.in);
        int opcion1 = 0;
        int opcion2 = 0;
        int opcion3 = 0;
        String nombre =usuario.getNombreE();

        try {
            while(opcion1<=0 || opcion2 <= 0 || opcion3 == 0){
                System.out.println("\n" + "Escoja tres pokemon de la siguiente lista."  + "\n");
                pokemones.desplegarCatalogo();
                opcion1 = scanner.nextInt();
                while(opcion1 > pokemones.longCatalogo()){
                    System.out.println("Numero incorrecto, vuelva a escoger su primer pokemon");
                    opcion1 = scanner.nextInt();
                }
                if (opcion1 >=0 && opcion1 <= pokemones.longCatalogo()){
                    Pokemon pokemon1 = buscarP(opcion1 - 1);
                    usuario.agregarAlEquipoPokemon(pokemon1);
                }
                System.out.println("\n" + "Escoja su segundo pokemon"  + "\n");
                opcion2 = scanner.nextInt();
                while(opcion2 > pokemones.longCatalogo()){
                    System.out.println("Numero incorrecto, vuelva a escoger su segundo pokemon");
                    opcion2 = scanner.nextInt();
                }
                if (opcion2 >= 0 && opcion2 <= pokemones.longCatalogo()){
                    Pokemon pokemon2 = buscarP(opcion2 - 1);
                    usuario.agregarAlEquipoPokemon(pokemon2);
                }
                System.out.println("\n" + "Escoja su tecer pokemon"  + "\n");
                opcion3 = scanner.nextInt();
                while(opcion3 > pokemones.longCatalogo()){
                    System.out.println("Numero incorrecto, vuelva a escoger su tercer pokemon");
                    opcion3 = scanner.nextInt();
                }
                if (opcion3 >= 0 && opcion3 <= pokemones.longCatalogo()){
                    Pokemon pokemon3 = buscarP(opcion3 - 1);
                    usuario.agregarAlEquipoPokemon(pokemon3);
                }
                
            }
            
        }
         catch (Exception e) {
            System.out.println("Escoja un número válido."  + "\n");
            scanner.nextLine();
        }

        System.out.println("¡Listo! Este es tu equipo pókemon: " + "\n");
        usuario.mostrarEquipoPokemon();
    }

    public Pokemon buscarP(int i){
        Pokemon p = null;
        for(int j = 0; j < pokemones.longCatalogo(); j++){
            if(i == j){
               p = pokemones.getListaP(i);
            }
        }
        return p;
    }

}