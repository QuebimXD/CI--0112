import java.util.Scanner;
public class Menu{
    private Entrenador entrenador;
    private Gimnasio gimnasio;
    private CatalogoP pokemones = new CatalogoP();

    public Menu(){
        gimnasio = new Gimnasio();
        String nombre = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al gimmnasio pokemon!");
        System.out.println("Por favor, escriba su nombre:");
        nombre = scanner.nextLine();
        gimnasio.setNombreEntrenador(nombre);
        System.out.println("Escoja a sus tres pokemon iniciales:");
        seleccionJugador();

        int opcion = 0;
        while (opcion <= 0){

            System.out.println("Empecemos el juego. Escoja una de las siguientes opciones:\n " +
                              "1-Entrar al gimnasio.\n 2-Ver a los entrenadores\n " +
                              "3-Ver mis pokemones y sus estadísticas.\n " +
                              "4-Salir");
            try {
                opcion = scanner.nextInt();
                if(opcion == 1){
                    System.out.println("Empieza tu primera batalla.");
                    int entrenadoresDerrotados = 0;
                    gimnasio.combate();
                    System.out.println("¡Has logrado terminar el gimmnasio!");
                }
                else if (opcion == 2){
                    System.out.println("Esto son los entrenadores con los cuales vas a competir: ");
                    gimnasio.mostrarEntrenadores();
                }
                else if (opcion == 3){
                    entrenador.mostrarInfoEquipoPokemon();
                }
                else if (opcion == 4){
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Escoja un número válido: ");

            }
        }


            
    }
    public void seleccionJugador(){
        Scanner scanner = new Scanner(System.in);
        int opcion1 = 0;
        int opcion2 = 0;
        int opcion3 = 0;
        String nombre =gimnasio.getNombreEntrenador();
        entrenador = new Entrenador(nombre);

        try {
            while(opcion1<=0 || opcion2 <= 0 || opcion3 <= 0){
                System.out.println("Escoja tres pokemon de la siguiente lista.");
                pokemones.desplegarCatalogo();
                opcion1 = scanner.nextInt() -1;
                if (opcion1 >=0){
                    Pokemon pokemon1 = buscarP(opcion1);
                    entrenador.agregarAlEquipoPokemon(pokemon1);
                }
                opcion2 = scanner.nextInt() -1;
                if (opcion2 >= 0){
                    Pokemon pokemon2 = buscarP(opcion2);
                    entrenador.agregarAlEquipoPokemon(pokemon2);
                }
                opcion3 = scanner.nextInt() -1;
                if (opcion3 >= 0){
                    Pokemon pokemon3 = buscarP(opcion3);
                    entrenador.agregarAlEquipoPokemon(pokemon3);
                }
                System.out.println("¡Listo! Este es tu equipo pókemon: ");
                entrenador.mostrarEquipoPokemon();
            }
        }
         catch (Exception e) {
            System.out.println("Escoja un número válido.");
        }

    }



    public Pokemon buscarP(int i){
        Pokemon p = null;
        for(int j = 0; j < pokemones.getListaP().length; j++){
            if(i == j){
               p = pokemones.getListaP()[i];
            }
        }
        return p;
    }

}