import java.util.Scanner;
public class Menu{
    public Menu(){
        Gimnasio gimnasio = new Gimnasio();
        int opcion = 0;
        String nombre = "";
        Scanner scanner = new Scanner(System.in);
        while (opcion <= 0){
            System.out.println("¡Bienvenido al gimmnasio pokemon!");
            System.out.println("Por favor, escriba su nombre:");
            nombre = scanner.nextLine();
            gimnasio.setNombreEntrenador(nombre);
            System.out.println("Escoja a sus tres pokemon iniciales:");
            seleccionJugador();
            System.out.println("Empecemos el juego.");
            }
    }
    public void seleccionJugador(){
        Scanner scanner = new Scanner(System.in);
        int opcion1 = 0;
        int opcion2 = 0;
        int opcion3 = 0;
        Entrenador entrenador = new Entrenador();
        entrenador.verCatalogo();
        try {
            while(opcion1<=0 & opcion2 <= 0 & opcion3 <= 0){
                System.out.println("Escoja tres pokemon de la siguiente lista.");
                entrenador.verCatalogoPokemon();
                opcion1 = scanner.nextInt();
                if (opcion1 >=0)
                    Pokemon pokemon1 = entrenador.getPokemonCatalogo(opcion1);
                    entrenador.agregarAlEquipoPokemon(pokemon1);
                }
                opcion2 = scanner.nextInt();
                if (opcion2 >= 0){
                    Pokemon pokemon2 = entrenador.getPokemonCatalogo(opcion2);
                    entrenador.agregarAlEquipoPokemon(pokemon2);
                }
                opcion3 = scanner.nextInt();
                if (opcion3 >= 0){
                    Pokemon pokemon3 = entrenador.getPokemonCatalogo(opcion3);
                    entrenador.agregarAlEquipoPokemon(pokemon3);
                }
        }
         catch (Excpetion e) {
            System.out.println("Escoja un número válido.");
        }

    }
}