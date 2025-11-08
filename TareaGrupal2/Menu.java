import java.util.Scanner;
public class Menu {
    private Scanner sc;
    private Juego juego;

    /**
     * Metodo constructor que se le muestra al usuario inicialmente. Le pregunta si quiere jugar una nueva partida, ver el puntaje de su partida anterior, o si se quiere salir. 
     * Hay manejo de errores que evitan que el usuario digite cosas no esperadas. Por ejemplo, si digita otro numero o un caracter.
     */
    public Menu() {
        sc = new Scanner(System.in);
        int opt = 0;

        while(opt != 3) {
            System.out.println("1- Nueva Partida\n2- Ver puntaje\n3- Salir");
            try {
                opt = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch(opt) {
                    case 1:
                        juego = new Juego();
                        juego.jugar();
                        break;
                    case 2:
                        System.out.println("Puntaje obtenido= " + juego.obtenerPuntaje());
                        break;
                    case 3:
                        System.out.println("Chao!");
                        break;
                    default:
                        System.out.println("Digite un número válido");
                }
            } catch(Exception e) {
                System.err.println("Digite un número");
                sc.nextLine(); // limpiar buffer
            }
        }
    }

}