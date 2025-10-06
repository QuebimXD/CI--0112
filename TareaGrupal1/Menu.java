import java.util.Scanner;
public class Menu{
    private Entrenador usuario;
    private Gimnasio gimnasio;
    private CatalogoP pokemones = new CatalogoP();

    public Menu(){
        usuario = new Entrenador("");
        gimnasio = new Gimnasio();
        String nombre = "";
        Scanner scanner = new Scanner(System.in);

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
                              "4-Salir");
            try {
                opcion = scanner.nextInt();
                if(opcion == 1){
                    System.out.println("Empieza tu primera batalla.");
                    gimnasio.logicaCombate(usuario);
                    int entrenadoresDerrotados = 0;
                    System.out.println("¡Has logrado terminar el gimmnasio!");
                }
                else if (opcion == 2){
                    System.out.println("Esto son los entrenadores con los cuales vas a competir: ");
                    gimnasio.mostrarEntrenadores();
                    opcion = -1;
                }
                else if (opcion == 3){
                    usuario.mostrarInfoEquipoPokemon();
                    opcion = -1;
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
        String nombre =usuario.getNombreE();

        try {
            while(opcion1<=0 || opcion2 <= 0 || opcion3 == 0){
                System.out.println("Escoja tres pokemon de la siguiente lista.");
                pokemones.desplegarCatalogo();
                opcion1 = scanner.nextInt();
                if (opcion1 >=0 && opcion1 <= pokemones.longCatalogo()){
                    Pokemon pokemon1 = buscarP(opcion1 - 1);
                    usuario.agregarAlEquipoPokemon(pokemon1);
                }
                System.out.println("Escoja su segundo pokemon");
                opcion2 = scanner.nextInt();
                if (opcion2 >= 0 && opcion2 <= pokemones.longCatalogo()){
                    Pokemon pokemon2 = buscarP(opcion2 - 1);
                    usuario.agregarAlEquipoPokemon(pokemon2);
                }
                System.out.println("Escoja su tecer pokemon");
                opcion3 = scanner.nextInt();
                if (opcion3 >= 0 && opcion3 <= pokemones.longCatalogo()){
                    Pokemon pokemon3 = buscarP(opcion3 - 1);
                    usuario.agregarAlEquipoPokemon(pokemon3);
                }
                
            }
            
        }
         catch (Exception e) {
            System.out.println("Escoja un número válido.");
        }

        System.out.println("¡Listo! Este es tu equipo pókemon: ");
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