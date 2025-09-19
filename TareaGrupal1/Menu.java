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
                    pokemon1 = getPokemon(opcion);
                    entrenador.agregarAlEquipoPokemon();
                opcion2 = scanner.nextInt();
                opcion3 = scanner.nextInt();
            }
        } catch (Excpetion e) {
        }

    }
}